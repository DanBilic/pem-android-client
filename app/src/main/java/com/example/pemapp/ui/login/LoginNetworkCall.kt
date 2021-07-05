package com.example.pemapp.ui.login

import com.example.pemapp.data.api.RetrofitInstance
import com.example.pemapp.ui.user.UserData

class LoginNetworkCall {
    suspend fun authRead(email:String, password:String): UserData {
        return RetrofitInstance.iLoginNetworkCall.authRead(email, password)
    }
}