package com.example.retrofit_uchun_loyixa.retrofit


import com.example.retrofit_uchun_loyixa.models.PostModel
import com.example.retrofit_uchun_loyixa.models.UserModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("plan")
    fun getAllTodo(): Call<List<PostModel>>

}

