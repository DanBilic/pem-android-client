package com.example.pemapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://10.0.2.2:5000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}