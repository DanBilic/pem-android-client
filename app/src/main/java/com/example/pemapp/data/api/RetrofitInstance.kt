package com.example.pemapp.data.api

import com.example.pemapp.ui.dashboard.moments.IMomentsNetworkCall
import com.example.pemapp.ui.login.ILoginNetworkCall
import com.example.pemapp.ui.user.IUserNetworkCall
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("http://10.0.2.2:5500/api/")
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

}