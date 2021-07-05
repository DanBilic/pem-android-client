package com.example.pemapp.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.ui.login.LoginDataConnection
import com.example.pemapp.ui.login.LoginNetworkCall

class UserConnectionFactory(private val userNetworkCall: UserNetworkCall) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserDataConnection(userNetworkCall) as T
    }
}