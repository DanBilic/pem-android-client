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
import com.example.pemapp.network.Connection
import com.example.pemapp.network.ConnectionFactory
import com.example.pemapp.data.repository.Repository
import com.google.android.material.snackbar.Snackbar
import com.example.pemapp.ui.discover.DashboardActivity
import com.example.pemapp.ui.profile.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {

    private lateinit var viewModel: Connection


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
        val viewModelFactory = ConnectionFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Connection::class.java)

        view.enterRegistrationButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        view.loginButton.setOnClickListener {
            viewModel.authRead(loginEmail.toString(), loginPassword.toString())
            viewModel.authResponse.observe(viewLifecycleOwner, { response ->

                if (response.status == "success") {
                    val intent = Intent(getActivity(), DashboardActivity::class.java)
                    intent.putExtra("Username",response.name)
                    intent.putExtra("Email", loginEmail.toString())
                    startActivity(intent)
                } else
                {
                    Snackbar.make(it,"Wrong password",Snackbar.LENGTH_LONG).show()
                }
            })

        }
        return view
    }

}