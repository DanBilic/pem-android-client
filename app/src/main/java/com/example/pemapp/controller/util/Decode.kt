package com.example.pemapp.controller.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

class Decode (private val string: String) {

    fun decode(): Bitmap {
        val imageBytes: ByteArray = Base64.decode(string, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }
}