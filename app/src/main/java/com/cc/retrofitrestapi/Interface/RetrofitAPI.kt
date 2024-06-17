package com.cc.retrofitrestapi.Interface

import com.cc.retrofitrestapi.Modal.Posts
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {

    //baseurl+post
    //https://jsonplaceholder.typicode.com/posts
/*
                    (@Query("latitude") userLatitude:String,
                    @Query("longtitude") userLongttiude:String
 */

    @GET("/posts")
    fun getAllPosts(): Call<List<Posts>>
}