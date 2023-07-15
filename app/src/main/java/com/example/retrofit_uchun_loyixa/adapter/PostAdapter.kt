package com.example.retrofit_uchun_loyixa.adapter

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.retrofit_uchun_loyixa.databinding.PostItemLayoutBinding
import com.example.retrofit_uchun_loyixa.models.PostModel


class PostAdapter(var list: List<PostModel>, var context: Context) :
    RecyclerView.Adapter<PostAdapter.Vh>() {

    inner class Vh(val postItemLayoutBinding: PostItemLayoutBinding) :
        RecyclerView.ViewHolder(postItemLayoutBinding.root) {
        fun onBind(postModel: PostModel) {
            postItemLayoutBinding.tvTitle.text = postModel.batafsil
            postItemLayoutBinding.tvDate.text = postModel.sana
            Glide.with(context).load("https://goo.gl/gEgYUd")
                .into(postItemLayoutBinding.imagePost)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(PostItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}