package com.cc.retrofitrestapi.Modal

import com.google.gson.annotations.SerializedName

data class Posts (
    val userID:Int,
    val id:Int,
    val title:String,
    @SerializedName("body")
    val subtitle:String  )
        //subtitle aslında gsonda body
//GSON ile aynı olursa daha rahat farklı degerler olursa annote etmek lazım
{

}