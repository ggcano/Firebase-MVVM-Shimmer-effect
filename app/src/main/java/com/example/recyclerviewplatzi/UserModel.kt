package com.example.recyclerviewplatzi

import java.io.Serializable

data class UserModel(
    val imageUrl: String = "Default",
    val name: String = "Name",
    val description: String = "Description",
    val phone: Int = 0
):Serializable