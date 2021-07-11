package com.example.pemapp.onboarding.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_onboarding1.view.*

class Onboarding1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding1, container, false)
        val location = view.findViewById<EditText>(R.id.location).text
        val locationLayout = view.findViewById<TextInputLayout>(R.id.locationTextField)

        view.nextButton1.setOnClickListener {
            if (TextUtils.isEmpty(location)) {
                locationLayout.setError(" Please Enter Your Location");
            } else {
                findNavController().navigate(R.id.action_onboarding1Fragment_to_onboarding2Fragment)
            }
            //Todo: save userName, location in Object
        }
        return view
    }
}

