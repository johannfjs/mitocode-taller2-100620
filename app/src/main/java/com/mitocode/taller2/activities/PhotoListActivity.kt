package com.mitocode.taller2.activities

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mitocode.taller2.ConfiguracionRetrofit
import com.mitocode.taller2.Metodos
import com.mitocode.taller2.adapters.PhotoListAdapter
import com.mitocode.taller2.databinding.ActivityPhotoListBinding
import com.mitocode.taller2.models.AlbumModel
import com.mitocode.taller2.models.PhotoModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoListActivity : AppCompatActivity(), PhotoListAdapter.PhotoListCallback {
    private lateinit var binding: ActivityPhotoListBinding
    private lateinit var adapter: PhotoListAdapter

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //switch
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra("item")) {
            val item = intent.getParcelableExtra<AlbumModel>("item")
            title = item!!.title

            adapter = PhotoListAdapter(this)
            binding.rvPhotos.layoutManager = GridLayoutManager(this, 2)
            binding.rvPhotos.adapter = adapter

            val retrofit = ConfiguracionRetrofit.obtenerConfiguracion().create(Metodos::class.java)
            val call = retrofit.obtenerFotos()
            call.enqueue(object : Callback<List<PhotoModel>> {
                override fun onResponse(
                    call: Call<List<PhotoModel>>,
                    response: Response<List<PhotoModel>>
                ) {
                    val respuesta = response.body()
                    adapter.addItems(respuesta)
                }

                override fun onFailure(call: Call<List<PhotoModel>>, t: Throwable) {
                    Log.d("taller2-log", "No trajo información de fotos")
                }

            })

            /*
            val data = ArrayList<PhotoModel>()
            data.add(
                PhotoModel(
                    1,
                    1,
                    "Foto 1",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg"
                )
            )
            data.add(
                PhotoModel(
                    2,
                    2,
                    "Foto 2",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg",
                    "https://i.pinimg.com/474x/8b/da/ca/8bdaca81d5ddbaeb92b61d6b5787d866.jpg"
                )
            )
            adapter.addItems(data)

             */
        }
    }

    override fun onClick(model: PhotoModel) {

    }
}