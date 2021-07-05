package com.example.pemapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pemapp.network.Connection
import com.example.pemapp.R

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: Connection
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}