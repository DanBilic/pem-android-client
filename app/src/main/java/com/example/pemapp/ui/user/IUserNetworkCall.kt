package com.example.pemapp.ui.user

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