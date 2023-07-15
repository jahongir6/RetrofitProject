package com.example.retrofit_uchun_loyixa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.retrofit_uchun_loyixa.adapter.PostAdapter
import com.example.retrofit_uchun_loyixa.adapter.UserAdapter
import com.example.retrofit_uchun_loyixa.databinding.ActivityMainBinding
import com.example.retrofit_uchun_loyixa.models.PostModel
import com.example.retrofit_uchun_loyixa.models.UserModel
import com.example.retrofit_uchun_loyixa.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var postAdapter: PostAdapter
    val userList = listOf(
        UserModel("", "jahongir"),
        UserModel("a", "abbos"),
        UserModel("", "salom"),
        UserModel("", "qale"),
        UserModel("", "yaxshi"),
        UserModel("", "ha mayli"),
    )
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.swipe.setOnRefreshListener(this)
        binding.swipe.isRefreshing = true
        User()
        Post()
    }

    fun User() {
        binding.recyclerUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        userAdapter = UserAdapter(userList, object : UserAdapter.UserAdapterListener {
            override fun onClick(userModel: UserModel) {
                val intent = Intent(this@MainActivity,PostActivity::class.java)
                intent.putExtra("extra_data",userModel)
                startActivity(intent)
            }

        })
        binding.recyclerUsers.adapter = userAdapter
    }

    fun Post() {

        ApiClient.getRetrofitService().getAllTodo()
            .enqueue(object : Callback<List<PostModel>> {
                override fun onResponse(
                    call: Call<List<PostModel>>,
                    response: Response<List<PostModel>>
                ) {
                    if (response.isSuccessful) {
                        binding.swipe.isRefreshing = false
                        response.body()?.let { postList ->
                            // Response gövdesi null değilse, PostAdapter sınıfını çağırın
                            postAdapter = PostAdapter(postList, this@MainActivity)
                            binding.recyclerPost.adapter = postAdapter
                        }
                    }
                }

                override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                    binding.swipe.isRefreshing = false
                }
            })
    }

    override fun onRefresh() {
        User()
        Post()
    }

}