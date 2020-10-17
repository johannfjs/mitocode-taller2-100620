package com.mitocode.taller2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mitocode.taller2.ConfiguracionRetrofit
import com.mitocode.taller2.Metodos
import com.mitocode.taller2.adapters.AlbumListAdapter
import com.mitocode.taller2.databinding.ActivityAlbumListBinding
import com.mitocode.taller2.models.AlbumModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val configuracion = ConfiguracionRetrofit.obtenerConfiguracion().create(Metodos::class.java)
        val call: Call<List<AlbumModel>> = configuracion.obtenerAlbunes()
        call.enqueue(object : Callback<List<AlbumModel>> {
            override fun onResponse(
                call: Call<List<AlbumModel>>,
                response: Response<List<AlbumModel>>
            ) {
                // ? quiere decir que puede ser nulo
                val respuesta: List<AlbumModel>? = response.body()
                adapter.addItems(respuesta)
            }

            override fun onFailure(call: Call<List<AlbumModel>>, t: Throwable) {
                Log.d("taller2_log", "No trajo datos")
            }
        })
/*
        val data = ArrayList<AlbumModel>()
        data.add(AlbumModel(1, "Title 1"))
        data.add(AlbumModel(2, "Title 2"))
        data.add(AlbumModel(3, "Title 30"))
        data.add(AlbumModel(4, "Title 4"))
        adapter.addItems(data)

 */
    }

    override fun onClick(model: AlbumModel) {
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("item", model)
        startActivity(intent)
    }
}