package com.mitocode.taller2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mitocode.taller2.databinding.ItemPhotoListBinding
import com.mitocode.taller2.models.PhotoModel

class PhotoListAdapter(val callback: PhotoListCallback) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list = ArrayList<PhotoModel>()
    private lateinit var binding: ItemPhotoListBinding

    inner class PhotoListViewHolder(itemView: View, private val context: Context) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(model: PhotoModel, position: Int) {
            binding.tvTitle.text = model.title
            Glide.with(context).load(model.url).into(binding.ivImage);
            binding.root.setOnClickListener {
                callback.onClick(model)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemPhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoListViewHolder(binding.root, parent.context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PhotoListViewHolder
        viewHolder.bind(list[position], position)
    }

    fun addItems(data: List<PhotoModel>?) {
        if (data != null) {
            list.clear()
            list.addAll(data)
            notifyDataSetChanged()
        }
    }

    interface PhotoListCallback {
        fun onClick(model: PhotoModel)
    }
}