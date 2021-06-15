package com.example.pemapp.repository

import com.example.pemapp.api.RetrofitInstance
import com.example.pemapp.model.Post

class Repository {
    suspend fun makeRead(): List<Post> {
        return RetrofitInstance.api.makeRead()
    }
}