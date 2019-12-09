package com.example.recyclerviewplatzi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewplatzi.ui.DetailActivity
import kotlinx.android.synthetic.main.item_row.view.*
import java.io.Serializable

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var dataList = mutableListOf<UserModel>()


    fun setLisData(data: MutableList<UserModel>) {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        } else {
            0
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataList[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("value", user)
            context.startActivity(intent)

        }

        holder.bindView(user)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),Serializable {

        fun bindView(user: UserModel) {
            Glide.with(context)
                .load(user.imageUrl)
                .into(itemView.circleImageView)

            itemView.txt_desc.text = user.description
            itemView.txt_title.text = user.name
        }
    }

}