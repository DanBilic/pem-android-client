package com.example.pemapp.user.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.user.model.UserData
import kotlinx.coroutines.launch

class UserDataConnection (private val userNetworkCall: UserNetworkCall): ViewModel() {
    val writeResponse: MutableLiveData<UserData> = MutableLiveData()
    val modiResponse: MutableLiveData<UserData> = MutableLiveData()

    fun pushWrite(post: UserData){
        viewModelScope.launch {
            writeResponse.value  = userNetworkCall.pushWrite(post)
        }
    }

    fun modiUser(email: String, post: UserData) {
        viewModelScope.launch {
            try {
                modiResponse.value  = userNetworkCall.modiUser(email, post)
            } catch (e: retrofit2.HttpException)
            { println(e) }
        }
    }
}