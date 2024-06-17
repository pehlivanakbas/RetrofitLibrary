package com.cc.retrofitrestapi.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cc.retrofitrestapi.Modal.Posts
import com.cc.retrofitrestapi.databinding.ListItemBinding

class PostsAdapter(var postlist: ArrayList<Posts>) :RecyclerView.Adapter<PostsAdapter.PostsViewHolder>(){

    //önce primary constructor sonra inner class oluşturacaz


    inner class PostsViewHolder(val adapterBinding:ListItemBinding) : RecyclerView.ViewHolder(adapterBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {

            val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return PostsViewHolder(binding)
    }

    override fun getItemCount(): Int {
            return postlist.size
        }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.adapterBinding.tvId.text=postlist[position].id.toString()
        holder.adapterBinding.tvUsrid.text=postlist[position].userID.toString()
        holder.adapterBinding.tvTitle.text=postlist[position].title
        holder.adapterBinding.tvSubtitle.text=postlist[position].subtitle


    }
}