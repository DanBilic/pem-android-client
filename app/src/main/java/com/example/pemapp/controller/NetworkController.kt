package com.example.pemapp.controller

import com.example.pemapp.dashboard.moments.network.IDiscoverNetworkCall
import com.example.pemapp.dashboard.moments.network.IMomentsNetworkCall
import com.example.pemapp.login.network.ILoginNetworkCall
import com.example.pemapp.user.network.IUserNetworkCall
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkController {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://10.0.2.2:5000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val iMomentsNetworkCall: IMomentsNetworkCall by lazy {
        retrofit.create(IMomentsNetworkCall::class.java)
    }
    val iLoginNetworkCall: ILoginNetworkCall by lazy {
        retrofit.create(ILoginNetworkCall::class.java)
    }

    val iUserNetworkCall: IUserNetworkCall by lazy {
        retrofit.create(IUserNetworkCall::class.java)
    }
    val iDiscoverNetworkCall: IDiscoverNetworkCall by lazy {
        retrofit.create(IDiscoverNetworkCall::class.java)
    }
}