package com.example.pemapp.data.model

import com.google.gson.annotations.SerializedName


data class UserModel (
    @SerializedName("userId")
    val _id: String,
    val name: String,
    val email: String,
    val password: String,
    val profilepicture: String,
    val status: String
)




