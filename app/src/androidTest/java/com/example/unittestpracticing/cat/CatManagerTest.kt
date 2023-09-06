package com.example.unittestpracticing.cat

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class CatManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test(expected = FileNotFoundException::class)
    fun testPopulateCatFromAssets() {
        //Arrange
        val catManager = CatManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        catManager.populateCatFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateCatFromAssets_InvalidJSON_expected_Exception() {
        //Arrange
        val catManager = CatManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        assertThrows(
            FileNotFoundException::class.java
        ) { catManager.populateCatFromAssets(context, "malformed.json") }

    }

    @Test
    fun testPopulateCatFromAssets_ValidJson_count_10() {
        //Arrange
        val catManager = CatManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        catManager.populateCatFromAssets(context, "cats.json")
        //Assert
        val result = catManager.getCatsCount()
        assertEquals(10, result)
    }

    @Test
    fun testPreviousCat_expected_CorrectQuote() {
        //Arrange
        val catManager = CatManager()
        catManager.populateCats(
            arrayOf(
                Cat(
                    id = "0",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                ),
                Cat(
                    id = "1",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                ),
                Cat(
                    id = "2",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                )
            )
        )
        //Act
        val result = catManager.getPreviousCat()
        //Assert
        assertEquals("0", result.id)
    }

    @Test
    fun testNextCat_expected_CorrectQuote() {
        //Arrange
        val catManager = CatManager()
        catManager.populateCats(
            arrayOf(
                Cat(
                    id = "0",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                ),
                Cat(
                    id = "1",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                ),
                Cat(
                    id = "2",
                    owner = "",
                    createdAt = null,
                    updatedAt = null
                )
            )
        )
        //Act
        val result = catManager.getNextCat()
        //Assert
        assertEquals("1", result.id)
    }
}