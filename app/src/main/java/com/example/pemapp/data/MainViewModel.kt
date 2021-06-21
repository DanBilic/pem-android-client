package com.example.pemapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.data.model.DataModel
import com.example.pemapp.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val readResponse: MutableLiveData<List<DataModel>> = MutableLiveData()
    val writeResponse: MutableLiveData<DataModel> = MutableLiveData()
    val authResponse: MutableLiveData<DataModel> = MutableLiveData()

    fun pushWrite(post: DataModel){
        viewModelScope.launch {
            writeResponse.value  = repository.pushWrite(post)
        }
    }
    fun makeRead(){
        viewModelScope.launch {
            readResponse.value  = repository.makeRead()
        }
    }

    fun authRead(email:String, password:String){
        viewModelScope.launch {
            authResponse.value  = repository.authRead(email, password)
        }
    }
}