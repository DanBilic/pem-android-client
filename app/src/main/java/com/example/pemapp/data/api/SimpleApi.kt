package com.example.pemapp.data.api

import com.example.pemapp.data.model.DataModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SimpleApi {

    @GET("users")
    suspend fun makeRead(): List<DataModel>

    @GET("auth_user")
    suspend fun authRead(
        @Query("email") email:String,
        @Query("password") password:String
    ): DataModel

    @POST("user")
    suspend fun pushWrite(
        @Body post: DataModel
    ): DataModel
}