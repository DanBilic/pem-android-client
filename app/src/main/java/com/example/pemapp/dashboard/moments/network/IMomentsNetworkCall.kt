package com.example.pemapp.dashboard.moments.network

import com.example.pemapp.dashboard.moments.model.MomentsData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IMomentsNetworkCall {
    @GET("moments")
    suspend fun getMoments(): List<MomentsData>

    @POST("moment")
    suspend fun postMoment(
        @Body post: MomentsData
    ): MomentsData
}