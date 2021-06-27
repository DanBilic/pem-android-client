package com.example.pemapp.data.repository

import com.example.pemapp.data.api.RetrofitInstance
import com.example.pemapp.data.model.UserModel
import com.example.pemapp.data.model.MomentModel

class Repository {

    suspend fun authRead(email:String, password:String): UserModel {
        return RetrofitInstance.api.authRead(email, password)
    }

    suspend fun pushWrite(post: UserModel): UserModel {
        return RetrofitInstance.api.pushWrite(post)
    }

    suspend fun getMoments(): List<MomentModel> {
        return RetrofitInstance.api.getMoments()
    }

    suspend fun postMoment(post: MomentModel): MomentModel {
        return RetrofitInstance.api.postMoment(post)
    }

    suspend fun modiUser(email: String, post: UserModel): UserModel {
        return RetrofitInstance.api.modiUser(email, post)
    }
}