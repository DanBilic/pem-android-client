package com.example.pemapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pemapp.R
import com.example.pemapp.login.network.LoginDataConnection

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginDataConnection
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}