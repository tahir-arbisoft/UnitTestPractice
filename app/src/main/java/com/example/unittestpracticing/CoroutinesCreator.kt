package com.example.unittestpracticing

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesCreator(
    val dispatcher: CoroutineDispatcher
) {

    suspend fun getUserName(): String {
        delay(10000)
        return "User Name"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(10000)
        }
        return "User"
    }

    suspend fun getAddress(): String {
        withContext(dispatcher) {
            delay(5000)
        }
        return "Address"
    }

    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }
}