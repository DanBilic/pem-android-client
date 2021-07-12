package com.example.pemapp.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {
    private var email: MutableLiveData<String> = MutableLiveData()
    private var username: MutableLiveData<String> = MutableLiveData()
    private var profilepicture: MutableLiveData<String> = MutableLiveData()

    fun setEmail(_email: String) {
        email.postValue(_email)
    }

    fun getEmail(): MutableLiveData<String> {
        return email
    }
    fun setUsernameDirectly(_username: String) {
        username.value = _username
    }

    fun getUsername(): MutableLiveData<String> {
        return username
    }
    fun setProfilepicture(_profilepicture: String) {
        profilepicture.postValue(_profilepicture)
    }

    fun getProfilepicture(): MutableLiveData<String> {
        return profilepicture
    }

}