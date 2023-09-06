package com.example.unittestpracticing.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.unittestpracticing.cat.Cat
import com.example.unittestpracticing.utils.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock

class CatDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var catDatabase: CatDatabase
    lateinit var catDao: CatDao

    @Before
    fun setUp() {
        Cat::class.java.getResourceAsStream("/cats.json")
        catDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CatDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        catDao = catDatabase.catDao()
    }

    @After
    fun tearDown() {
        catDatabase.close()
    }

    @Test
    fun testInsertCat_expected1Cat() = runBlocking {
        // Arrange
        val cat = Cat(
            id = "0",
            owner = "Owner1",
            createdAt = null,
            updatedAt = null
        )

        // Act
        catDao.insertCat(cat)

        // Assert
        val result = catDao.getCats().getOrAwaitValue()
        assertEquals(1, result.size)
    }

    @Test
    fun testDeleteCat_expected0Cat() = runBlocking {
        // Arrange
        val cat = Cat(
            id = "0",
            owner = "Owner1",
            createdAt = null,
            updatedAt = null
        )

        // Act
        catDao.insertCat(cat)
        catDao.delete()

        // Assert
        val result = catDao.getCats().getOrAwaitValue()
        assertEquals(0, result.size)
    }
}