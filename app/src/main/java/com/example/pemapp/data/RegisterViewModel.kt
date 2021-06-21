package com.example.pemapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    private var email: MutableLiveData<String> = MutableLiveData()
    private var password: MutableLiveData<String> = MutableLiveData()

    fun setEmail(_email: String) {
        email.postValue(_email);
    }

    fun getEmail(): MutableLiveData<String> {
        return email
    }

    fun setPassword(_pw: String) {
        password.postValue(_pw)
    }

    fun getPassword(): MutableLiveData<String> {
        return password
    }

}