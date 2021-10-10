package com.minionz.qrna.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = "http://13.209.117.145:8080"

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val networkService : NetworkService = getRetrofit().create(NetworkService::class.java)
}