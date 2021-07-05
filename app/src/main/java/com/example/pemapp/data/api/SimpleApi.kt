package com.example.pemapp.data.api

import com.example.pemapp.ui.user.UserData
import com.example.pemapp.ui.dashboard.moments.MomentsData
import retrofit2.http.*

interface SimpleApi {

    @GET("auth_user")
    suspend fun authRead(
        @Query("email") email:String,
        @Query("password") password:String
    ): UserData

    @POST("user")
    suspend fun pushWrite(
        @Body post: UserData
    ): UserData

    @GET("moments")
    suspend fun getMoments(): List<MomentsData>

    @POST("moment")
    suspend fun postMoment(
        @Body post: MomentsData
    ): MomentsData

    @PUT("modify_user")
    suspend fun modiUser(
        @Query("email") email:String,
        @Body post: UserData
    ): UserData

}