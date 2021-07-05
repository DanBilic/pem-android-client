package com.example.pemapp.ui.discover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.ui.profile.ProfileViewModel

import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val profileName = intent.getStringExtra("Username")
        val profileEmail = intent.getStringExtra("Email")
        val profilePicture = intent.getStringExtra("Profilepicture")

        //Initialize bottom navigation view
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navController = findNavController(R.id.dashboardNavHostFragment)
        bottomNavigationView.setupWithNavController(navController)

        if (profileName != null) {
            profileViewModel.setUsernameDirectly(profileName)
        }
        if (profileEmail != null) {
            profileViewModel.setEmail(profileEmail)
        }
        if (profilePicture != null) {
            profileViewModel.setProfilepicture(profilePicture)
        }
    }
}