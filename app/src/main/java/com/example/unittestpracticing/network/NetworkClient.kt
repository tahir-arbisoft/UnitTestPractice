package com.example.unittestpracticing.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    private lateinit var retrofitClient: Retrofit

    private fun getRetrofitClient(): Retrofit {
        if (!NetworkClient::retrofitClient.isInitialized) {
            retrofitClient = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cataas.com/api/")
                .build()
        }
        return retrofitClient
    }

    fun getCatsAPI(): CatsAPI {
        return getRetrofitClient().create(CatsAPI::class.java)
    }
}