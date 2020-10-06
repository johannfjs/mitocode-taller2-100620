package com.mitocode.taller2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mitocode.taller2.databinding.ItemAlbumListBinding
import com.mitocode.taller2.models.AlbumModel

class AlbumListAdapter(val callback: AlbumListCallback) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var binding: ItemAlbumListBinding
    private val list = ArrayList<AlbumModel>()

    inner class AlbumListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: AlbumModel, position: Int) {
            binding.tvTitle.text = model.title

            binding.root.setOnClickListener {
                callback.onClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemAlbumListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumListViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as AlbumListViewHolder
        viewHolder.bind(list[position], position)
    }

    fun addItems(data: ArrayList<AlbumModel>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    interface AlbumListCallback {
        fun onClick(model: AlbumModel)
    }
}