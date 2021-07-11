package com.example.pemapp.dashboard.moments.network

import com.example.pemapp.controller.NetworkController
import com.example.pemapp.dashboard.discover.MicroTaskData
import com.example.pemapp.dashboard.moments.model.MomentsData

class DiscoverNetworkCall {
    suspend fun getMicroTaskData(): List<MicroTaskData> {
        return NetworkController.iDiscoverNetworkCall.getMicroTaskData()
    }

}

