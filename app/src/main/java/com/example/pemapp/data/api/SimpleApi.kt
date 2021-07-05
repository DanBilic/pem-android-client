package com.example.pemapp.data.api

import com.example.pemapp.data.model.UserModel
import com.example.pemapp.data.model.MomentModel
import retrofit2.http.*

interface SimpleApi {

    @GET("auth_user")
    suspend fun authRead(
        @Query("email") email:String,
        @Query("password") password:String
    ): UserModel

    @POST("user")
    suspend fun pushWrite(
        @Body post: UserModel
    ): UserModel

    @GET("moments")
    suspend fun getMoments(): List<MomentModel>

    @POST("moment")
    suspend fun postMoment(
        @Body post: MomentModel
    ): MomentModel

    @PUT("modify_user")
    suspend fun modiUser(
        @Query("email") email:String,
        @Body post: UserModel
    ): UserModel

}