package com.example.pemapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.model.Post
import com.example.pemapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<List<Post>> = MutableLiveData()
    fun makeRead(){
        viewModelScope.launch {
            val response : List<Post> = repository.makeRead()
            myResponse.value = response
        }
    }
}