package com.example.pemapp.login.network

import com.example.pemapp.user.model.UserData
import retrofit2.http.GET
import retrofit2.http.Query

interface ILoginNetworkCall {
    @GET("auth_user")
    suspend fun authRead(
        @Query("email") email:String,
        @Query("password") password:String
    ): UserData
}