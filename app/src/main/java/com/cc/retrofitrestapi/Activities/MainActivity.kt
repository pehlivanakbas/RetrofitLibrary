package com.cc.retrofitrestapi.Activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cc.retrofitrestapi.Adapters.PostsAdapter
import com.cc.retrofitrestapi.Interface.RetrofitAPI
import com.cc.retrofitrestapi.Modal.Posts
import com.cc.retrofitrestapi.R
import com.cc.retrofitrestapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val baseUrl:String="https://jsonplaceholder.typicode.com/"
    lateinit var mainBinding: ActivityMainBinding
    lateinit var adapter: PostsAdapter
    var postList=ArrayList<Posts>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding=ActivityMainBinding.inflate(layoutInflater)
        val view=mainBinding.root
        setContentView(view)
        mainBinding.rvPosts.layoutManager=LinearLayoutManager(this)

        showPosts()

    }



    private fun showPosts(){
        val retrofit=Retrofit.Builder().
        baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //retrofit API objesi oluşturacaz
        val retrofilAPI:RetrofitAPI=retrofit.create(RetrofitAPI::class.java)

        val call : Call<List<Posts>> =retrofilAPI.getAllPosts()

        call.enqueue(object : Callback<List<Posts>> {

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                if (response.isSuccessful) {

                    mainBinding.progressBar.isVisible = true

                    postList = response.body() as ArrayList<Posts>
                    adapter = PostsAdapter(postList)
                    mainBinding.rvPosts.adapter = adapter

                    mainBinding.progressBar.isVisible = false

                }
            }


            override fun onFailure(p0: Call<List<Posts>>, p1: Throwable) {
                Toast.makeText(applicationContext,p1.localizedMessage,Toast.LENGTH_SHORT).show()            }

        })
    }
}






/*
https://jsonplaceholder.typicode.com/
burada farklı türde Json formatı var calışmak için kullanılabilir



1- İLK olarak modal class oluşturulur
2-Interface oluşturacağız
3- rv ici adapter yapısını kuralım
 */