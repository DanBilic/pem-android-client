package com.example.pemapp.dashboard.profile.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pemapp.dashboard.moments.model.MomentsData

class ProfileViewModel: ViewModel() {
    private var username: MutableLiveData<String> = MutableLiveData()
    private var email: MutableLiveData<String> = MutableLiveData()
    private var profilepicture: MutableLiveData<String> = MutableLiveData()

    private var moments: MutableLiveData<List<MomentsData>> = MutableLiveData()
    private var text: MutableLiveData<String> = MutableLiveData()
    private var posttime: MutableLiveData<String> = MutableLiveData()
    private var picture: MutableLiveData<String> = MutableLiveData()

    fun setUsername(_username: String) {
        username.postValue(_username)
    }

    fun setUsernameDirectly(_username: String) {
        username.value = _username
    }

    fun getUsername(): MutableLiveData<String> {
        return username
    }

    fun setEmail(_email: String) {
        email.postValue(_email)
    }

    fun getEmail(): MutableLiveData<String> {
        return email
    }

    fun setProfilepicture(_profilepicture: String) {
        profilepicture.postValue(_profilepicture)
    }

    fun getProfilepicture(): MutableLiveData<String> {
        return profilepicture
    }



    fun setUsers(_users: List<MomentsData>) {
        moments.postValue(_users)
    }


    fun setPosttime(_posttime: String) {
        posttime.postValue(_posttime);
    }

    fun getPosttime(): MutableLiveData<String> {
        return posttime
    }

    fun setPicture(_picture: String) {
        picture.postValue(_picture)
    }

    fun getPicture(): MutableLiveData<String> {
        return picture
    }

}