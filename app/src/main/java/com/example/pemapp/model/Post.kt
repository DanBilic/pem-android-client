package com.example.pemapp.model

import com.google.gson.annotations.SerializedName


data class Post (
    @SerializedName("userId")
    val _id: String,
    val name: String,
    val email: String,
    val gender: String

    )




