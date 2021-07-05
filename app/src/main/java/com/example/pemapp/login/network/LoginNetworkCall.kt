package com.example.pemapp.login.network

import com.example.pemapp.controller.NetworkController
import com.example.pemapp.user.model.UserData

class LoginNetworkCall {
    suspend fun authRead(email:String, password:String): UserData {
        return NetworkController.iLoginNetworkCall.authRead(email, password)
    }
}