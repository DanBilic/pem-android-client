package com.example.pemapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.MainViewModel
import com.example.pemapp.MainViewModelFactory
import com.example.pemapp.R
import com.example.pemapp.repository.Repository

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.makeRead()
        viewModel.myResponse.observe(this, Observer { response ->
            /*Log.d("Response", response._id)
            Log.d("Response", response.name)
            Log.d("Response", response.email)
            Log.d("Response", response.gender)*/
            println(response)
        })
    }
}