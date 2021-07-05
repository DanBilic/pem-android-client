package com.example.pemapp.ui.dashboard.moments

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