package com.example.pemapp.repositories

import com.example.pemapp.api.RetrofitInstance
import com.example.pemapp.models.TokenResult
import com.example.pemapp.models.User
import retrofit2.Response

class DragRepository {

    suspend fun login(password: String, email: String): Response<TokenResult>{
        return RetrofitInstance.api.login(password, email)
    }
}