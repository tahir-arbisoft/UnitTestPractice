package com.example.unittestpracticing.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.unittestpracticing.cat.Cat

@Dao
interface CatDao {
    @Insert
    suspend fun insertCat(cat: Cat)

    @Update
    suspend fun updateCat(cat: Cat)

    @Query("DELETE FROM cat")
    suspend fun delete()

    @Query("SELECT * FROM cat")
    fun getCats(): LiveData<List<Cat>>

    @Query("SELECT * FROM cat WHERE id = :catId")
    suspend fun getCatById(catId: String): Cat
}