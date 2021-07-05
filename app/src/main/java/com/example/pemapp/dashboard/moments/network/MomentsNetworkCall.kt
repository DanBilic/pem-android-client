package com.example.pemapp.dashboard.moments.network

import com.example.pemapp.controller.NetworkController
import com.example.pemapp.dashboard.moments.model.MomentsData

class MomentsNetworkCall {
    suspend fun getMoments(): List<MomentsData> {
        return NetworkController.iMomentsNetworkCall.getMoments()
    }
    suspend fun postMoment(post: MomentsData): MomentsData {
        return NetworkController.iMomentsNetworkCall.postMoment(post)
    }
}

