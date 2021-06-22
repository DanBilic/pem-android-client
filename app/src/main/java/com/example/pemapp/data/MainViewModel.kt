package com.example.pemapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.data.model.DataModel
import com.example.pemapp.data.model.MomentModel
import com.example.pemapp.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val writeResponse: MutableLiveData<DataModel> = MutableLiveData()
    val authResponse: MutableLiveData<DataModel> = MutableLiveData()

    val getMoments: MutableLiveData<List<MomentModel>> = MutableLiveData()
    val postMoment: MutableLiveData<MomentModel> = MutableLiveData()

    fun pushWrite(post: DataModel){
        viewModelScope.launch {
            writeResponse.value  = repository.pushWrite(post)
        }
    }

    fun authRead(email:String, password:String){
        viewModelScope.launch {
            try {
                authResponse.value  = repository.authRead(email, password)
            } catch (e: retrofit2.HttpException) {
                authResponse.value = DataModel("", "wrong password", "", "", "")
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
}