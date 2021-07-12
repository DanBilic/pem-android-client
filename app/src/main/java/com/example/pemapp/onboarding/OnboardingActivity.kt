package com.example.pemapp.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pemapp.R
import com.example.pemapp.dashboard.profile.model.ProfileViewModel

class OnboardingActivity : AppCompatActivity() {
    private val onboardingViewModel: OnboardingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val email = intent.getStringExtra("email")
        val username = intent.getStringExtra("username")
        if (email != null) {
            onboardingViewModel.setEmail(email)
            onboardingViewModel.setUsernameDirectly(username!!)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}