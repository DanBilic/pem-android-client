package com.example.pemapp.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.data.model.UserModel
import com.example.pemapp.data.model.MomentModel
import com.example.pemapp.data.repository.Repository
import kotlinx.coroutines.launch

class Connection(private val repository: Repository): ViewModel() {

    val writeResponse: MutableLiveData<UserModel> = MutableLiveData()
    val authResponse: MutableLiveData<UserModel> = MutableLiveData()

    val getMoments: MutableLiveData<List<MomentModel>> = MutableLiveData()
    val postMoment: MutableLiveData<MomentModel> = MutableLiveData()

    val modiResponse: MutableLiveData<UserModel> = MutableLiveData()

    fun pushWrite(post: UserModel){
        viewModelScope.launch {
            writeResponse.value  = repository.pushWrite(post)
        }
    }

    fun authRead(email:String, password:String){
        viewModelScope.launch {
            try {
                authResponse.value  = repository.authRead(email, password)
            } catch (e: retrofit2.HttpException) {
                authResponse.value = UserModel("", "", "", "", "", "wrong password")
                println(e)
            }
        }
    }

    fun getMoments(){
        viewModelScope.launch {
            getMoments.value  = repository.getMoments()
        }
    }

    fun postMoment(post: MomentModel){
        viewModelScope.launch {
            postMoment.value  = repository.postMoment(post)
        }
    }

    fun modiUser(email: String, post: UserModel) {
        viewModelScope.launch {
            try {
                modiResponse.value  = repository.modiUser(email, post)
            } catch (e: retrofit2.HttpException)
            { println(e) }
        }
    }
}