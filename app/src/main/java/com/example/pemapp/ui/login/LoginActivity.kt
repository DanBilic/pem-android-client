package com.example.pemapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pemapp.network.Connection
import com.example.pemapp.R
import com.example.pemapp.tracking.location.NearbyPlaces

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: Connection
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        NearbyPlaces().getUserLocation(this, this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        NearbyPlaces().onRequestPermissionsResult(requestCode, permissions, grantResults, this, this)
    }
}