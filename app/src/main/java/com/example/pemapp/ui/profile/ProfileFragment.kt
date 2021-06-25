package com.example.pemapp.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.R
import com.example.pemapp.network.Connection
import kotlinx.android.synthetic.main.fragment_discover.view.*

class ProfileFragment : Fragment() {

    private lateinit var username : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username = view.findViewById<TextView>(R.id.nameTextView)
        var email = view.findViewById<TextView>(R.id.emailTextView)

        val profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        profileViewModel.getUsername().observe(viewLifecycleOwner, {
            username.text = it
        })


        if(profileViewModel.getEmail().value != null) {
            email.text = profileViewModel.getEmail().value!!
        }
    }

}