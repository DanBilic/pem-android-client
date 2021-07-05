package com.example.pemapp.ui.discover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.ui.appUsage.AppUsageModel
import com.example.pemapp.ui.profile.ProfileViewModel

import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        AppUsageModel.setContext(this)
        checkPermission()

        val profileName = intent.getStringExtra("Username")
        val profileEmail = intent.getStringExtra("Email")

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
    }

    private fun checkPermission(){
        val appUsageModel = AppUsageModel()
        if(!appUsageModel.checkUsageStatePermission()) {
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }
    }
}