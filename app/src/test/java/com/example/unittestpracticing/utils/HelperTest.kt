package com.example.unittestpracticing.utils

import org.junit.After
import org.junit.Test
import org.junit.Assert.*;
import org.junit.Before

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setup() {
        helper = Helper()
        println("Before every unit test")
    }

    @After
    fun tearDown() {
        println("After ever unit test")
    }

    @Test
    fun isPalindrome() {
        // Arrange
//        val helper = Helper()
        // Act
        val result = helper.isPalindrome("a")
        // Assert
        assertEquals(true, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        // Arrange
//        val helper = Helper()
        // Act
        val result = helper.isPalindrome("")
        // Assert
        assertEquals(true, result)
    }
}