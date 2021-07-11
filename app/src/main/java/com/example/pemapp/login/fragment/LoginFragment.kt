package com.example.pemapp.login.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.google.android.material.snackbar.Snackbar
import com.example.pemapp.dashboard.DashboardActivity
import com.example.pemapp.login.network.LoginConnectionFactory
import com.example.pemapp.login.network.LoginDataConnection
import com.example.pemapp.login.network.LoginNetworkCall
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {
    private lateinit var loginDataConnection: LoginDataConnection

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
        val loginField = view.findViewById<TextInputLayout>(R.id.emailTextField)
        val passwordField = view.findViewById<TextInputLayout>(R.id.passwordTextField)


        val loginNetworkCall = LoginNetworkCall()
        val loginConnectionFactory = LoginConnectionFactory(loginNetworkCall)
        loginDataConnection = ViewModelProvider(this, loginConnectionFactory).get(
            LoginDataConnection::class.java
        )

        view.enterRegistrationButton.setOnClickListener {
            if (TextUtils.isEmpty(loginEmail)) {
                loginField.setError(" Please Enter Your E-Mail");
            } else if (TextUtils.isEmpty(loginPassword)) {
                passwordField.setError(" Please Enter Your Password");
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }
        }

        view.loginButton.setOnClickListener {
            if (TextUtils.isEmpty(loginEmail)) {
                loginField.setError(" Please Enter Your E-Mail");
            } else if (TextUtils.isEmpty(loginPassword)) {
                passwordField.setError(" Please Enter Your Password");
            } else {
                loginDataConnection.authRead(loginEmail.toString(), loginPassword.toString())
                loginDataConnection.authResponse.observe(viewLifecycleOwner, { response ->
                    if (response.status == "success") {
                        val intent = Intent(getActivity(), DashboardActivity::class.java)
                        intent.putExtra("Username", response.name)
                        intent.putExtra("Email", loginEmail.toString())
                        intent.putExtra("Profilepicture", response.profilepicture)
                        startActivity(intent)
                    } else {
                        Snackbar.make(it, "Wrong password", Snackbar.LENGTH_LONG).show()
                    }
                })
            }
        }
        return view
    }

}