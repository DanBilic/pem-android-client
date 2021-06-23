package com.example.pemapp.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.data.repository.Repository

class ConnectionFactory(private val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return Connection(repository) as T
    }
}