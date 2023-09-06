package com.example.unittestpracticing.cat

import android.content.Context
import com.google.gson.Gson

class CatManager {

    private val catList = mutableListOf<Cat>()
    private var currentCatIndex = 0

    fun populateCatFromAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        catList.addAll(gson.fromJson(json, Array<Cat>::class.java))
    }

    fun populateCats(cats: Array<Cat>) {
        this.catList.clear()
        this.catList.addAll(cats)
    }

    fun getCurrentCat(): Cat {
        return catList[currentCatIndex]
    }

    fun getNextCat(): Cat {
        if (currentCatIndex == catList.size - 1) return catList[currentCatIndex]
        return catList[++currentCatIndex]
    }

    fun getPreviousCat(): Cat {
        if (currentCatIndex == 0) return catList[currentCatIndex]
        return catList[--currentCatIndex]
    }

    fun getCatsCount(): Int {
        return catList.size
    }
}