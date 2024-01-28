package com.example.m17_recyclerview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m17_recyclerview.R
import com.example.m17_recyclerview.databinding.MyViewGroupBinding
import com.example.m17_recyclerview.entity.SinglePhoto

class PhotosAdapter (private val values: List<SinglePhoto?>) :
    RecyclerView.Adapter<PhotosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = MyViewGroupBinding.inflate(LayoutInflater.from(parent.context))
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val items = values[position]
        holder.binding.topText.text = items?.earth_date.toString()
        holder.binding.bottomText.text = items?.sol.toString()
        val context = holder.binding.imageView.context
        Glide.with(context).load(items?.img_src.toString()).into(holder.binding.imageView)

        holder.binding.imageView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("param1", items?.img_src.toString())
            }
            it.findNavController().navigate(R.id.action_mainFragment_to_photoFragment, bundle)
        }
    }
}

class PhotosViewHolder(val binding: MyViewGroupBinding) : RecyclerView.ViewHolder(binding.root)