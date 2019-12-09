package com.example.recyclerviewplatzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModel
import com.example.recyclerviewplatzi.UserModel
import com.example.recyclerviewplatzi.domain.network.Repo

class MainViewModel: ViewModel() {

    private val repo = Repo()

    fun userData(): MutableLiveData<MutableList<UserModel>> {
        val mutableData = MutableLiveData<MutableList<UserModel>>()
        repo.getUserData().observeForever{ userList ->
            mutableData.value = userList
        }
        return mutableData
    }
}