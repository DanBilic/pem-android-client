package com.example.pemapp.onboarding.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pemapp.R
import com.example.pemapp.onboarding.OnbordingItem
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.user.network.UserNetworkCall
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_onboarding1.view.*

class Onboarding1Fragment : Fragment() {

    private lateinit var userDataConnection: UserDataConnection

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding1, container, false)
        val location = view.findViewById<EditText>(R.id.location)
        val locationLayout = view.findViewById<TextInputLayout>(R.id.locationTextField)

        val userNetworkCall = UserNetworkCall()
        val userConnectionFactory = UserConnectionFactory(userNetworkCall)
        userDataConnection = ViewModelProvider(this, userConnectionFactory).get(UserDataConnection::class.java)


        view.nextButton1.setOnClickListener {
            if (TextUtils.isEmpty(location.text)) {
                locationLayout.setError(" Please Enter Your Location");
            } else {
                //val bundle = arguments
               // val bundle = getArguments()

                val myWrite = UserData("", "", "",
                    "", "", location.text.toString(), "", "")


               /* val onbordingItem = OnbordingItem()
                println(onbordingItem.getEmail())
                userDataConnection.modiUser(onbordingItem.getEmail(), myWrite)
*/
               /* if (bundle != null) {
                    println(bundle.getString("email")!!)
                }

                if (bundle != null) {

                }*/
                findNavController().navigate(R.id.action_onboarding1Fragment_to_onboarding2Fragment)
            }

        }
        return view
    }
}

