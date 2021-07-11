package com.example.pemapp.dashboard.moments.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DiscoverConnectionFactory(private val discoverNetworkCall: DiscoverNetworkCall) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DiscoverDataConnection(discoverNetworkCall) as T
    }
}