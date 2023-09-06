package com.example.unittestpracticing.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unittestpracticing.cat.Cat

@Database(entities = [Cat::class], version = 1)
abstract class CatDatabase : RoomDatabase() {

    abstract fun catDao(): CatDao
}