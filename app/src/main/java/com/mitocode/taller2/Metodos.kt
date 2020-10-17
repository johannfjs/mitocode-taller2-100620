package com.mitocode.taller2

import com.mitocode.taller2.models.AlbumModel
import com.mitocode.taller2.models.PhotoModel
import retrofit2.Call
import retrofit2.http.GET

interface Metodos {
    @GET("albums")
    fun obtenerAlbunes(): Call<List<AlbumModel>>

    @GET("photos")
    fun obtenerFotos(): Call<List<PhotoModel>>
}