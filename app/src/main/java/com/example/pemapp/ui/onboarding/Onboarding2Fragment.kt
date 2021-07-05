package com.example.pemapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.network.Connection
import kotlinx.android.synthetic.main.fragment_onboarding3.view.*


class Onboarding2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding2, container, false)

        view.nextButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboarding2Fragment_to_onboarding3Fragment)
        }

        return view
    }



}