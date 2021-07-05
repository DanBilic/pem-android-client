package com.example.pemapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.ui.user.UserData
import kotlinx.coroutines.launch

class LoginDataConnection(private val loginNetworkCall: LoginNetworkCall): ViewModel() {
    val authResponse: MutableLiveData<UserData> = MutableLiveData()

    fun authRead(email:String, password:String){
        viewModelScope.launch {
            try {
                authResponse.value  = loginNetworkCall.authRead(email, password)
            } catch (e: retrofit2.HttpException) {
                authResponse.value = UserData("", "", "", "", "", "wrong password")
                println(e)
            }
        }
    }
}