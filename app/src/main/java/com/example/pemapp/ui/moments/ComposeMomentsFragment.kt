package com.example.pemapp.ui.moments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Base64.encodeToString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.data.model.MomentModel
import com.example.pemapp.data.repository.Repository
import com.example.pemapp.network.Connection
import com.example.pemapp.network.ConnectionFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_compose_moments.view.*
import java.io.ByteArrayOutputStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ComposeMomentsFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var inputView: EditText
    private lateinit var viewModel: Connection
    private val RECORD_REQUEST_CODE = 101
    val PICK_IMAGE = 1

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_compose_moments, container, false)


        val repository = Repository()
        val viewModelFactory = ConnectionFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Connection::class.java)


        imageView = view.findViewById(R.id.imageView)
        inputView = view.findViewById(R.id.inputMoments)


        setupPermissions()
        view.postButton.setOnClickListener {
            saveDataIntoDatabase(CreateImageStringFromBitmap())
            Snackbar.make(it,"successful", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_composeMomentsFragment_to_momentsFragment)
        }

        view.addPictureButton.setOnClickListener {

            selectImageInAlbum()
        }

        return view
    }

    private fun CreateImageStringFromBitmap(): String {
        val bitmap = (imageView.getDrawable() as BitmapDrawable).bitmap

       // val bitmap: Bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.linux)

        val stream = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

        val byteArray: ByteArray = stream.toByteArray()

        return encodeToString(byteArray, Base64.DEFAULT)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun saveDataIntoDatabase(imageString: String) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formattedTime = current.format(formatter)

        val text = inputView.text.toString()

        val myWrite = MomentModel("", "Lori, Susan", text, imageString, formattedTime, "")
        viewModel.postMoment(myWrite)

    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE)
    }

    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri = data?.data
            imageView.setImageURI(imageUri)
        }
    }
}