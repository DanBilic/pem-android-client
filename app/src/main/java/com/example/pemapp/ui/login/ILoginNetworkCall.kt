package com.example.pemapp.ui.login

import com.example.pemapp.ui.user.UserData
import retrofit2.http.GET
import retrofit2.http.Query

interface ILoginNetworkCall {
    @GET("auth_user")
    suspend fun authRead(
        @Query("email") email:String,
        @Query("password") password:String
    ): UserData
}