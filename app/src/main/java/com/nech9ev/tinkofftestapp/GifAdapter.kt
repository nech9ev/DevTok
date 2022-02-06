package com.nech9ev.tinkofftestapp

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nech9ev.domain.model.Gif

class GifAdapter(val context: Context) : RecyclerView.Adapter<GifViewHolder>() {

    private var gifList = ArrayList<Gif>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(parent)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(gifList[position], context)
    }

    override fun getItemCount(): Int = gifList.size

    fun addGif(newGif: Gif) {
        gifList.add(newGif)
        notifyItemInserted(gifList.lastIndex)
    }

    fun clear() {
        gifList.clear()
        notifyDataSetChanged()
    }

}