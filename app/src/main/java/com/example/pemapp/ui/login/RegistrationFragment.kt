package com.example.pemapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.data.MainViewModel
import com.example.pemapp.data.MainViewModelFactory
import com.example.pemapp.data.RegisterViewModel
import com.example.pemapp.data.model.DataModel
import com.example.pemapp.data.repository.Repository
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegistrationFragment : Fragment() {

    private val registerModel: RegisterViewModel by viewModels()
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        val regiEmail = view.findViewById<EditText>(R.id.regi_email).text
        val regiPassword = view.findViewById<EditText>(R.id.regi_pw).text


        view.registerButton.setOnClickListener {
            val myWrite = DataModel("","goodusername", regiEmail.toString(), regiPassword.toString(), "neutral")
            viewModel.pushWrite(myWrite)
            Snackbar.make(it,"successfully registered", Snackbar.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        return view
    }


}
