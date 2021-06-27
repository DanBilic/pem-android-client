package com.example.pemapp.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import android.widget.ImageView
import java.io.ByteArrayOutputStream

class Encode (private val imageView: ImageView) {

    fun CreateImageStringFromBitmap(): String {
        val bitmap = (imageView.getDrawable() as BitmapDrawable).bitmap

        // val bitmap: Bitmap = BitmapFactory.decodeResource(this.resources, R.drawable.linux)

        val stream = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)

        val byteArray: ByteArray = stream.toByteArray()

        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}