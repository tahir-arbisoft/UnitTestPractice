package com.example.unittestpracticing.cat

import android.content.Context
import android.content.res.AssetManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CatManagerJVMTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testCatStream() {
        val testStream = Cat::class.java.getResourceAsStream("/cats.json")
        given(context.assets).willReturn(assetManager)
        given(context.assets.open(anyString())).willReturn(testStream)

        val testClass = CatManager()
        testClass.populateCatFromAssets(context, "")
        val cat = testClass.getCurrentCat()

        assertEquals("ricardo.ricardo0", cat.owner)
    }
}