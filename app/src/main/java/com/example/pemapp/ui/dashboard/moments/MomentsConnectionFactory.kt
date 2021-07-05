package com.example.pemapp.ui.dashboard.moments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MomentsConnectionFactory(private val momentsNetworkCall: MomentsNetworkCall) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MomentsDataConnection(momentsNetworkCall) as T
    }
}