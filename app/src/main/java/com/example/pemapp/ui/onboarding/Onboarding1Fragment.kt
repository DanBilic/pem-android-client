package com.example.pemapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.data.model.DataModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_onboarding3.view.*


class Onboarding1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding1, container, false)

        val userName = view.findViewById<EditText>(R.id.userName).text
        val location = view.findViewById<EditText>(R.id.location).text

        view.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding1Fragment_to_onboarding2Fragment)
        }

        return view
    }
}