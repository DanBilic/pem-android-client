package com.example.pemapp.fragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.user.network.UserNetworkCall
import kotlinx.android.synthetic.main.fragment_registration.view.*


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)


        val regiEmail = view.findViewById<EditText>(R.id.regi_email).text
        val regiPassword = view.findViewById<EditText>(R.id.regi_pw).text
        val regiUsername = view.findViewById<EditText>(R.id.regi_username).text


        view.registerButton.setOnClickListener {

            findNavController().navigate(R.id.action_registrationFragment_to_onboarding_nav)
        }

        return view
    }


}