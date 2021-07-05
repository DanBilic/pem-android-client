package com.example.pemapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginConnectionFactory(private val loginNetworkCall: LoginNetworkCall) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginDataConnection(loginNetworkCall) as T
    }
}