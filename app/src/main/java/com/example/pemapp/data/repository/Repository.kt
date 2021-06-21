package com.example.pemapp.data.repository

import com.example.pemapp.data.api.RetrofitInstance
import com.example.pemapp.data.model.DataModel

class Repository {
    suspend fun makeRead(): List<DataModel> {
        return RetrofitInstance.api.makeRead()
    }

    suspend fun pushWrite(post: DataModel): DataModel {
        return RetrofitInstance.api.pushWrite(post)
    }
}