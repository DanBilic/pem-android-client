package com.example.pemapp.onboarding.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.DashboardActivity
import com.example.pemapp.onboarding.Categories
import com.example.pemapp.onboarding.ChipAdapter
import com.example.pemapp.onboarding.OnboardingViewModel
import com.example.pemapp.user.model.UserData
import com.example.pemapp.user.network.UserConnectionFactory
import com.example.pemapp.user.network.UserDataConnection
import com.example.pemapp.user.network.UserNetworkCall
import kotlinx.android.synthetic.main.chip_element.view.*
import kotlinx.android.synthetic.main.fragment_onboarding3.*
import kotlinx.android.synthetic.main.fragment_onboarding3.view.*

class Onboarding3Fragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var userDataConnection: UserDataConnection
    private val selectedList: MutableList<String> = mutableListOf()
    private lateinit var email : String
    private lateinit var username: String
    private lateinit var profilepicture: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding3, container, false)

        val onboardingViewModel = ViewModelProvider(requireActivity()).get(OnboardingViewModel::class.java)
        onboardingViewModel.getEmail().observe(viewLifecycleOwner, {
            email = it
        })
        onboardingViewModel.getUsername().observe(viewLifecycleOwner, {
            username = it
        })
        onboardingViewModel.getProfilepicture().observe(viewLifecycleOwner, {
            profilepicture = it
        })

        val userNetworkCall = UserNetworkCall()
        val userConnectionFactory = UserConnectionFactory(userNetworkCall)
        userDataConnection = ViewModelProvider(this, userConnectionFactory).get(UserDataConnection::class.java)


        view.saveButton.setOnClickListener {
            getSelectedCategories()

            val intent = Intent(getActivity(), DashboardActivity::class.java)
            intent.putExtra("Username", username)
            intent.putExtra("Email", email)
            intent.putExtra("Profilepicture", profilepicture)
            startActivity(intent)

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewChips)
        recyclerViewChips.apply {
            layoutManager = GridLayoutManager(activity, 3)
            recyclerView.layoutManager = layoutManager
            adapter = ChipAdapter(Categories.categoriesList)
        }
    }

    fun getSelectedCategories() {
        var size = Categories.categoriesList.size - 1
        for (item in 0..size) {
            var chipItem = recyclerView.getChildAt(item).chip
            if (chipItem.isChecked) {
                selectedList.add(chipItem.text as String)
            }
        }
       /* val myWrite = UserData("", "", "",
            "", "", "", selectedList, "")

        userDataConnection.modiUser(email, myWrite)*/
    }
}

