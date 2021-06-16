package com.example.pemapp.repository

import com.example.pemapp.api.RetrofitInstance
import com.example.pemapp.model.DataModel
import retrofit2.Response

class Repository {
    suspend fun makeRead(): List<DataModel> {
        return RetrofitInstance.api.makeRead()
    }

    suspend fun pushWrite(post:DataModel): DataModel {
        return RetrofitInstance.api.pushWrite(post)
    }
}