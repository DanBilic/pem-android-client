package com.example.pemapp.dashboard.profile.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.R
import com.example.pemapp.dashboard.profile.model.ProfileViewModel
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.notification.Notification
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.network.UserNetworkCall
import com.example.pemapp.controller.util.Decode
import com.example.pemapp.controller.util.Encode
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var username : TextView
    private lateinit var email : TextView
    private lateinit var userDataConnection: UserDataConnection
    private val RECORD_REQUEST_CODE = 101
    val PICK_IMAGE = 1
    var notificationId = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val userNetworkCall = UserNetworkCall()
        val userConnectionFactory = UserConnectionFactory(userNetworkCall)
        userDataConnection = ViewModelProvider(this, userConnectionFactory).get(UserDataConnection::class.java)


        imageView = view.findViewById(R.id.profilepicture)
        username = view.findViewById(R.id.nameTextView)
        email = view.findViewById(R.id.emailTextView)
        setupPermissions()

        username.setOnClickListener{
            val notification = Notification(requireContext())
            notification.showNotification(notificationId)
        }
        view.profilepicture.setOnClickListener {
            selectImageInAlbum()

        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        profileViewModel.getUsername().observe(viewLifecycleOwner, {
            username.text = it
        })


        if(profileViewModel.getEmail().value != null) {
            email.text = profileViewModel.getEmail().value!!
        }

        if(profileViewModel.getProfilepicture().value != "") {
            val decodedBitmap = Decode(profileViewModel.getProfilepicture().value!!).decode()
            imageView.setImageBitmap(decodedBitmap)
        }
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
            saveToDatabase()

        }
    }

    private fun saveToDatabase() {
        val encode = Encode(imageView)

        val myWrite = UserData("", "", "",
            "", encode.createImageStringFromBitmap(), "", "", "")

        userDataConnection.modiUser(email.text.toString(), myWrite)

    }

}