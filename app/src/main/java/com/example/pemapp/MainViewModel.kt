package com.example.pemapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.model.DataModel
import com.example.pemapp.repository.Repository
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val readResponse: MutableLiveData<List<DataModel>> = MutableLiveData()
    val writeResponse: MutableLiveData<DataModel> = MutableLiveData()

    fun pushWrite(post:DataModel){
        viewModelScope.launch {
            writeResponse.value  = repository.pushWrite(post)
        }
    }
    fun makeRead(){
        viewModelScope.launch {
            readResponse.value  = repository.makeRead()
        }
    }
}