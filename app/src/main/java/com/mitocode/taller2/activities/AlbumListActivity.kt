package com.mitocode.taller2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mitocode.taller2.adapters.AlbumListAdapter
import com.mitocode.taller2.databinding.ActivityAlbumListBinding
import com.mitocode.taller2.models.AlbumModel

class AlbumListActivity : AppCompatActivity(), AlbumListAdapter.AlbumListCallback {
    private lateinit var binding: ActivityAlbumListBinding
    private lateinit var adapter: AlbumListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AlbumListAdapter(this)
        binding.rvAlbum.layoutManager = LinearLayoutManager(this)
        binding.rvAlbum.adapter = adapter

        val data = ArrayList<AlbumModel>()
        data.add(AlbumModel(1, "Title 1"))
        data.add(AlbumModel(2, "Title 2"))
        data.add(AlbumModel(3, "Title 3"))
        data.add(AlbumModel(4, "Title 4"))
        adapter.addItems(data)
    }

    override fun onClick(model: AlbumModel) {
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("item", model)
        startActivity(intent)
    }
}