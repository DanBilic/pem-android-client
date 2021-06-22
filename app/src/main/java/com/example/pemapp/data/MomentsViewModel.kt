package com.example.pemapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pemapp.data.model.MomentModel

class MomentsViewModel: ViewModel() {
    private var username: MutableLiveData<String> = MutableLiveData()
    private var users: MutableLiveData<List<MomentModel>> = MutableLiveData()
    private var text: MutableLiveData<String> = MutableLiveData()
    private var posttime: MutableLiveData<String> = MutableLiveData()
    private var profilepicture: MutableLiveData<String> = MutableLiveData()
    private var picture: MutableLiveData<String> = MutableLiveData()

    fun setUsername(_username: String) {
        username.postValue(_username);
    }

    fun getUsername(): MutableLiveData<String> {
        return username
    }

    fun setUsers(_users: List<MomentModel>) {
        users.postValue(_users)
    }



    fun setText(_text: String) {
        text.postValue(_text)
    }

    fun getText(): MutableLiveData<String> {
        return text
    }
    fun setPosttime(_posttime: String) {
        posttime.postValue(_posttime);
    }

    fun getPosttime(): MutableLiveData<String> {
        return posttime
    }

    fun setProfilepicture(_profilepicture: String) {
        profilepicture.postValue(_profilepicture)
    }

    fun getProfilepicture(): MutableLiveData<String> {
        return profilepicture
    }
    fun setPicture(_picture: String) {
        picture.postValue(_picture)
    }

    fun getPicture(): MutableLiveData<String> {
        return picture
    }

}