package com.example.pemapp.ui.dashboard.moments

import com.example.pemapp.data.api.RetrofitInstance

class MomentsNetworkCall {
    suspend fun getMoments(): List<MomentsData> {
        return RetrofitInstance.iMomentsNetworkCall.getMoments()
    }
    suspend fun postMoment(post: MomentsData): MomentsData {
        return RetrofitInstance.iMomentsNetworkCall.postMoment(post)
    }
}

