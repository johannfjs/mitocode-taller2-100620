package com.mitocode.taller2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfiguracionRetrofit {
    companion object {
        fun obtenerConfiguracion(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    /*
    public final Retrofit obtenerConfiguracion(){
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
     */
}