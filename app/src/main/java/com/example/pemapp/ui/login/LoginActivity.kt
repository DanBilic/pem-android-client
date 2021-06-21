package com.example.pemapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pemapp.data.MainViewModel
import com.example.pemapp.R
import com.example.pemapp.data.RegisterViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val registerModel: RegisterViewModel by viewModels()
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        /*val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.makeRead()
        viewModel.readResponse.observe(this, Observer { response ->
            //println(response)
        })


        loginModel.getEmail().observe(this, {
            email = it
        })

        loginModel.getPassword().observe(this, {
            password = it
        })

        viewModel.authRead("yuemail", "test")
        viewModel.authResponse.observe(this, Observer { response ->
            println(response.name)
        })

        val myWrite = DataModel("","mynameisyu", "yuemail", "test", "weiblich")
        viewModel.pushWrite(myWrite)*/
    }
}