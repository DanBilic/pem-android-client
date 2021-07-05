package com.example.pemapp.user.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserConnectionFactory(private val userNetworkCall: UserNetworkCall) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDataConnection(userNetworkCall) as T
    }
}