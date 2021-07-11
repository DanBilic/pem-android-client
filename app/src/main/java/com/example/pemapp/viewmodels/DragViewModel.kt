package com.example.pemapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemapp.models.TokenResult
import com.example.pemapp.repositories.DragRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class DragViewModel (private val repository: DragRepository): ViewModel(){
    val loginData : MutableLiveData<Response<TokenResult>> = MutableLiveData()

    fun login(password: String, email: String){
        viewModelScope.launch {
            loginData.value = repository.login(password, email)
        }
    }
}