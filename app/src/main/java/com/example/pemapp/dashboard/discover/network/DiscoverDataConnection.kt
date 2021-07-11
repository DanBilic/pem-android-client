package com.example.pemapp.dashboard.moments.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.dashboard.discover.MicroTaskData
import com.example.pemapp.dashboard.moments.model.MomentsData
import kotlinx.coroutines.launch

class DiscoverDataConnection(private val discoverNetworkCall: DiscoverNetworkCall) : ViewModel() {
    val getMicroTaskData: MutableLiveData<List<MicroTaskData>> = MutableLiveData()

    fun getMicroTaskData() {
        viewModelScope.launch {
            getMicroTaskData.value = discoverNetworkCall.getMicroTaskData()
        }
    }

}