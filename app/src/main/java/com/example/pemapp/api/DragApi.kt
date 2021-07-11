package com.example.pemapp.api

import com.example.pemapp.models.TokenResult
import com.example.pemapp.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DragApi {
    @POST("api/v1/auth/login")
    suspend fun login(@Body email: String, @Body password: String): Response<TokenResult>
}