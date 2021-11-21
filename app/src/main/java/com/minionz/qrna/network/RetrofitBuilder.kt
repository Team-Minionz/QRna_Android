package com.minionz.qrna.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val baseUrl = "http://www.qrna.kro.kr"

    fun getRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val networkService : NetworkService = getRetrofit().create(NetworkService::class.java)
}