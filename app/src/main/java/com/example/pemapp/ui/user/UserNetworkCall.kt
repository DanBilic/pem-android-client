package com.example.pemapp.ui.user

import com.example.pemapp.data.api.RetrofitInstance

class UserNetworkCall {
    suspend fun pushWrite(post: UserData): UserData {
        return RetrofitInstance.api.pushWrite(post)
    }

    suspend fun modiUser(email: String, post: UserData): UserData {
        return RetrofitInstance.api.modiUser(email, post)
    }
}