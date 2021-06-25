package com.example.pemapp.data.model

import com.google.gson.annotations.SerializedName


data class DataModel (
    @SerializedName("userId")
    val _id: String,
    val name: String,
    val email: String,
    val password: String,
    val status: String
)




