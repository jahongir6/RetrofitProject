package com.example.retrofit_uchun_loyixa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_uchun_loyixa.databinding.UserItemLayoutBinding
import com.example.retrofit_uchun_loyixa.models.UserModel

class UserAdapter(var list: List<UserModel>, val adapterListener: UserAdapterListener) :
    RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(val userItemLayoutBinding: UserItemLayoutBinding) :
        RecyclerView.ViewHolder(userItemLayoutBinding.root) {
        fun onBind(userModel: UserModel) {
            userItemLayoutBinding.tvName.text = userModel.sarlavha
            userItemLayoutBinding.root.setOnClickListener {
                adapterListener.onClick(userModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(UserItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    interface UserAdapterListener {
        fun onClick(userModel: UserModel)
    }
}