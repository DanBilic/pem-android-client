package com.example.pemapp.user.model

import com.google.gson.annotations.SerializedName


data class UserData (
    @SerializedName("userId")
    val _id: String,
    val name: String,
    val email: String,
    val password: String,
    val profilepicture: String,
    val location: String,
    val hobby: String,
    val status: String
)




