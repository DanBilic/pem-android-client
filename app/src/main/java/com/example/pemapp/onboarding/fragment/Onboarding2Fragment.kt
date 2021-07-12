package com.example.pemapp.onboarding.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.controller.util.Encode
import com.example.pemapp.onboarding.OnboardingViewModel
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.user.network.UserNetworkCall
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_onboarding2.view.*
import kotlinx.android.synthetic.main.fragment_onboarding2.view.nextButton2

class Onboarding2Fragment : Fragment() {
    private lateinit var userDataConnection: UserDataConnection
    private lateinit var onboardingViewModel: OnboardingViewModel
    private val REQUEST_CODE = 42
    private val RECORD_REQUEST_CODE = 101
    val PICK_IMAGE = 1
    private lateinit var imageView: ImageView
    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding2, container, false)
        imageView = view.findViewById(R.id.photoView)

        setupPermissions()
        val userNetworkCall = UserNetworkCall()
        val userConnectionFactory = UserConnectionFactory(userNetworkCall)
        userDataConnection = ViewModelProvider(this, userConnectionFactory).get(UserDataConnection::class.java)


        onboardingViewModel = ViewModelProvider(requireActivity()).get(OnboardingViewModel::class.java)
        onboardingViewModel.getEmail().observe(viewLifecycleOwner, {
            email = it
        })

        view.nextButton2.setOnClickListener {
            saveToDatabase()

            findNavController().navigate(R.id.action_onboarding2Fragment_to_onboarding3Fragment)
        }

        view.photoButton.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(activity?.packageManager!!) != null) {
                startActivityForResult(takePictureIntent, REQUEST_CODE)
            } else {
                Snackbar.make(it, "Unable to open camera", Snackbar.LENGTH_SHORT).show()
            }

        }
        view.galleryButton.setOnClickListener {
            selectImageInAlbum()
        }
        return view
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(
            requireActivity(),
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            RECORD_REQUEST_CODE
        )
    }

    fun selectImageInAlbum() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri = data?.data
            imageView.setImageURI(imageUri)

        } else if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            val takenImage = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(takenImage)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun saveToDatabase() {
        val encode = Encode(imageView)
        val encodedPicture = encode.createImageStringFromBitmap()

        val myWrite = UserData("", "", "",
            "", encodedPicture, "", listOf(), "")

        userDataConnection.modiUser(email, myWrite)
        onboardingViewModel.setProfilepicture(encodedPicture)

    }

}