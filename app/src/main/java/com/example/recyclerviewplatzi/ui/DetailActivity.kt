package com.example.recyclerviewplatzi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recyclerviewplatzi.R
import com.example.recyclerviewplatzi.UserModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_row.view.*

class DetailActivity : AppCompatActivity() {

    private var user: UserModel ?= null
    private var datalista: ArrayList<UserModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        loadData(intent)
    }


    private fun loadData (intent: Intent){

        if (intent.hasExtra("value")) {
        user = intent.getSerializableExtra("value") as UserModel
            loadTexts()
            }
    }

    private fun loadTexts(){
        textView_phone.text = user?.phone.toString()
        textView_name.text = user?.name
        loadUrl()


    }

   private fun loadUrl (){
        Glide.with(this)
            .load(user?.imageUrl)
            .into(imageView_photo)
    }
}
