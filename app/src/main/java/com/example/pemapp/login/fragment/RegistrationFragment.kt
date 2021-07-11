package com.example.pemapp.login.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.user.network.UserNetworkCall
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_registration.view.*
import org.w3c.dom.Text


class RegistrationFragment : Fragment() {

    private lateinit var userDataConnection: UserDataConnection

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)


        val userNetworkCall = UserNetworkCall()
        val userConnectionFactory = UserConnectionFactory(userNetworkCall)
        userDataConnection =
            ViewModelProvider(this, userConnectionFactory).get(UserDataConnection::class.java)


        val regiEmail = view.findViewById<EditText>(R.id.regi_email).text
        val regiPassword = view.findViewById<EditText>(R.id.regi_pw).text
        val regi2Password = view.findViewById<EditText>(R.id.regi2_pw).text
        val regiUsername = view.findViewById<EditText>(R.id.regi_username).text
        val regiEmailField = view.findViewById<TextInputLayout>(R.id.emailTextField)
        val regiPasswordField = view.findViewById<TextInputLayout>(R.id.passwordTextField)
        val regiPassword2Field = view.findViewById<TextInputLayout>(R.id.password2TextField)
        val regiUsernameField = view.findViewById<TextInputLayout>(R.id.usernameInputField)

        view.registerButton.setOnClickListener {
            if (TextUtils.isEmpty(regiEmail)) {
                regiEmailField.setError(" Please Enter Your E-Mail");
            } else if (TextUtils.isEmpty(regiPassword)) {
                regiPasswordField.setError(" Please Enter Your Password");
            } else if (TextUtils.isEmpty(regi2Password)) {
                regiPassword2Field.setError(" Please Enter Your Password");
            } else if (TextUtils.isEmpty(regiUsername)) {
                regiUsernameField.setError("Please Enter Your User Name")
            } else {
                val myWrite = UserData(
                    "", regiUsername.toString(), regiEmail.toString(),
                    regiPassword.toString(), "", ""
                )
                userDataConnection.pushWrite(myWrite)
                Snackbar.make(it, "successfully registered", Snackbar.LENGTH_LONG).show()

                findNavController().navigate(R.id.action_registrationFragment_to_onboarding_nav)
            }
        }

        return view
    }


}
