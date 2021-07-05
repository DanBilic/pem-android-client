package com.example.pemapp.ui.dashboard.moments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MomentsDataConnection(private val momentsNetworkCall: MomentsNetworkCall) : ViewModel() {
    val getMoments: MutableLiveData<List<MomentsData>> = MutableLiveData()
    val postMoments: MutableLiveData<MomentsData> = MutableLiveData()

    fun getMoments() {
        viewModelScope.launch {
            getMoments.value = momentsNetworkCall.getMoments()
        }
    }

    fun postMoment(post: MomentsData) {
        viewModelScope.launch {
            postMoments.value = momentsNetworkCall.postMoment(post)
        }
    }
}