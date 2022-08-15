package com.example.ituneskotlinapp.Views.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ituneskotlinapp.Models.MusicData
import com.example.ituneskotlinapp.R
import com.example.ituneskotlinapp.databinding.BodyContainerLayoutBinding
import com.squareup.picasso.Picasso

class PopAdapter(var musicList:List<MusicData>, private var openData:(MusicData)-> Unit)
    : RecyclerView.Adapter<PopAdapter.ViewHolder>() {
    class ViewHolder(private val binding: BodyContainerLayoutBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun onBinding(dataItem : MusicData, openData: (MusicData) -> Unit){
            binding.title.text= dataItem.artistName
            binding.classic.text = dataItem.collectionCensoredName
            binding.price.text = dataItem.trackPrice +" USD"
            Picasso.get()
                .load(dataItem.artworkUrl100)
                .placeholder(R.drawable.ic_baseline_home_24)
                .error(R.drawable.ic_baseline_home_24)
                .into(binding.homeBanner)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return PopAdapter.ViewHolder(
            BodyContainerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBinding(musicList[position],openData)
    }
    fun updateList(response: List<MusicData>){
        musicList = response
        Log.d("musicList", "updateList:${response} ")
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        Log.d("HelloClassic", "getItemCount: ${musicList.size}")
        return musicList.size
    }
}