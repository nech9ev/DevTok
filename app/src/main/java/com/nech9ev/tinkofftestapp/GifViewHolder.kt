package com.nech9ev.tinkofftestapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nech9ev.domain.model.Gif
import com.nech9ev.tinkofftestapp.databinding.ViewGifItemBinding

class GifViewHolder(
    parent: ViewGroup,
    private val binding: ViewGifItemBinding =
        ViewGifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gifState: Gif, context: Context ) {
        binding.ivGif.loadGif(gifUrl = gifState.gifUrl, context)
        gifState.apply {
            binding.tvDescription.text = "$description\n@$author"
        }
    }

}

private fun ImageView.loadGif(
    gifUrl: String,
    context: Context
) {
    Glide.with(context)
        .asGif()
        .load(gifUrl)
        .placeholder(R.drawable.load_placeholder)
        .centerInside()
        .into(this)
}