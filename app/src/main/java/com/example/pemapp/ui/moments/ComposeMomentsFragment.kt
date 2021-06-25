package com.example.pemapp.ui.moments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.util.Base64.encodeToString
import android.util.Base64
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.data.model.DataModel
import com.example.pemapp.data.model.MomentModel
import com.example.pemapp.data.repository.Repository
import com.example.pemapp.network.Connection
import com.example.pemapp.network.ConnectionFactory
import com.google.android.material.snackbar.Snackbar
import java.io.ByteArrayOutputStream
import kotlinx.android.synthetic.main.fragment_compose_moments.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ComposeMomentsFragment : Fragment() {

    private lateinit var encodedImageString: String
    private lateinit var imageView: ImageView
    private lateinit var inputView: EditText
    private lateinit var viewModel: Connection

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
        encodedImageString = CreateImageStringFromBitmap()



        view.postButton.setOnClickListener {
            saveDataIntoDatabase(encodedImageString)
            Snackbar.make(it,"successful", Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_composeMomentsFragment_to_momentsFragment)
        }

        return view
    }

    private fun CreateImageStringFromBitmap(): String {

        val bitmap: Bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.linux)

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
}