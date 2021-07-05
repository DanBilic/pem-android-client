package com.example.pemapp.ui.dashboard.moments

import com.example.pemapp.data.api.RetrofitInstance

class MomentsNetworkCall {
    suspend fun getMoments(): List<MomentsData> {
        return RetrofitInstance.api.getMoments()
    }
    suspend fun postMoment(post: MomentsData): MomentsData {
        return RetrofitInstance.api.postMoment(post)
    }
}

