package com.example.recyclerviewplatzi.domain.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewplatzi.UserModel
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getUserData(): LiveData<MutableList<UserModel>> {
        val mutableData = MutableLiveData<MutableList<UserModel>>()
        FirebaseFirestore.getInstance().collection("usuarios").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<UserModel>()
                for (document in result) {
                    val imageUrlFire = document.getString("imageUrl")
                    val nameFire = document.getString("name")
                    val descriptionFire = document.getString("description")
                    val phoneFire = document.get("phone", Int::class.java)
                    val user =
                        UserModel(imageUrlFire!!, nameFire?:"", descriptionFire!!, phoneFire ?: 0)

                    listData.add(user)
                }
                mutableData.value = listData
            }
        return mutableData
    }
}