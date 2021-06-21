package com.example.pemapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.data.RegisterViewModel
import com.example.pemapp.data.MainViewModel
import com.example.pemapp.data.MainViewModelFactory
import com.example.pemapp.data.repository.Repository
import com.example.pemapp.ui.discover.DiscoverActivity
import androidx.lifecycle.Observer
import com.example.pemapp.data.model.DataModel
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {

    private val registerModel: RegisterViewModel by viewModels()
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginEmail = view.findViewById<EditText>(R.id.login_email).text
        val loginPassword = view.findViewById<EditText>(R.id.login_password).text


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        view.enterRegistrationButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        view.loginButton.setOnClickListener {
            val intent = Intent(getActivity(), DiscoverActivity::class.java)
            startActivity(intent)


            viewModel.authRead(loginEmail.toString(), loginPassword.toString())
            viewModel.authResponse.observe(viewLifecycleOwner, { response ->
                println(response.name)
            })
        }
        return view
    }

    /*override fun onResume() {
        super.onResume()
        if(registerModel.getEmail().value != null) {
            regiEmail = registerModel.getEmail().value!!
            println(regiEmail)
        }
        if(registerModel.getPassword().value != null) {
            regiPassword = registerModel.getPassword().value!!
            println(regiPassword)
        }
        val myWrite = DataModel("","goodusername", regiEmail, regiPassword, "neutral")
        viewModel.pushWrite(myWrite)
    }*/

}