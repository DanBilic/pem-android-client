package com.example.pemapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.data.MainViewModel
import com.example.pemapp.data.MainViewModelFactory
import com.example.pemapp.R
import com.example.pemapp.data.model.DataModel
import com.example.pemapp.data.repository.Repository

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.makeRead()
        viewModel.readResponse.observe(this, Observer { response ->
            /*Log.d("Response", response._id)
            Log.d("Response", response.name)
            Log.d("Response", response.email)
            Log.d("Response", response.gender)*/
            println(response)
        })

        val myWrite = DataModel("fake text", "sunYu", "@campus.lmu", "weiblich")
        viewModel.pushWrite(myWrite)
    }
}