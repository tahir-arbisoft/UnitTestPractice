package com.example.unittestpracticing.network

import com.example.unittestpracticing.cat.Cat
import retrofit2.http.GET

interface CatsAPI {

    @GET("cats?tags=cute")
    suspend fun getAllCuteCats(): List<Cat>
}