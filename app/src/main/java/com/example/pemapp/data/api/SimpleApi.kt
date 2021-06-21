package com.example.pemapp.data.api

import com.example.pemapp.data.model.DataModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SimpleApi {

    @GET("read")
    suspend fun makeRead(): List<DataModel>

    @POST("post")
    suspend fun pushWrite(
        @Body post: DataModel
    ): DataModel
}