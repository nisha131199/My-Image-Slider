package com.ongraph.imageslider

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ongraph.imageslider.databinding.ImageSliderBinding

class ImageSliderAdapter(private val images: List<String>) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(binding: ImageSliderBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val actualPosition = position % images.size
        val imageUrl = images[actualPosition]
        Glide.with(holder.imageView.context)
            .load(imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = images.size
}