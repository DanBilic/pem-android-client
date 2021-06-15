package com.example.pemapp.api

import com.example.pemapp.model.Post
import retrofit2.http.GET

interface SimpleApi {

    @GET("read")
    suspend fun makeRead(): List<Post>
}