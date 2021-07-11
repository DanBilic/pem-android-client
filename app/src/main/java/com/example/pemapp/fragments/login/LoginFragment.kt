package com.example.pemapp.fragments.login

import android.content.Intent
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
import com.example.pemapp.dashboard.DashboardActivity
import com.example.pemapp.login.network.LoginConnectionFactory
import com.example.pemapp.login.network.LoginDataConnection
import com.example.pemapp.login.network.LoginNetworkCall
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login2.view.*

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login2, container, false)




        view.enterRegistrationButton2.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment)
        }


        return view
    }


}