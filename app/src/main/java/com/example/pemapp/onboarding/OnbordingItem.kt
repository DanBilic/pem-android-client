package com.example.pemapp.onboarding

class OnbordingItem {
    private lateinit var email: String

    fun setEmail(_email: String) {
        email = _email
    }

    fun getEmail(): String {
        return email
    }

}