package com.example.pemapp.user.network

import com.example.pemapp.controller.NetworkController
import com.example.pemapp.user.model.UserData

class UserNetworkCall {
    suspend fun pushWrite(post: UserData): UserData {
        return NetworkController.iUserNetworkCall.pushWrite(post)
    }

    suspend fun modiUser(email: String, post: UserData): UserData {
        return NetworkController.iUserNetworkCall.modiUser(email, post)
    }
}