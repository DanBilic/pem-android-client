package com.example.pemapp.user.network

import com.example.pemapp.user.model.UserData
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface IUserNetworkCall {
    @POST("user")
    suspend fun pushWrite(
        @Body post: UserData
    ): UserData



    @PUT("modify_user")
    suspend fun modiUser(
        @Query("email") email:String,
        @Body post: UserData
    ): UserData

}