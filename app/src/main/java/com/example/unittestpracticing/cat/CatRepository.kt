package com.example.unittestpracticing.cat

import com.example.unittestpracticing.network.NetworkClient

class CatRepository {

    private val catService = NetworkClient.getCatsAPI()

    suspend fun getCuteCats(): List<Cat> {
        return catService.getAllCuteCats()
    }
}