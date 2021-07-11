package com.example.pemapp.dashboard.moments.network

import com.example.pemapp.dashboard.discover.MicroTaskData
import com.example.pemapp.dashboard.moments.model.MomentsData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IDiscoverNetworkCall {
    @GET("microtasks")
    suspend fun getMicroTaskData(): List<MicroTaskData>

}