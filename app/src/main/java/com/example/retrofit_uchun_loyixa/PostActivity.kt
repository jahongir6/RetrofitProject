package com.example.retrofit_uchun_loyixa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit_uchun_loyixa.databinding.ActivityPostBinding
import com.example.retrofit_uchun_loyixa.models.UserModel

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private lateinit var userModel: UserModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userModel = intent.getSerializableExtra("extra_data") as UserModel

        binding.tvTitle.text = userModel.sarlavha
    }
}