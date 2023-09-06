package com.example.unittestpracticing.utils

import org.junit.Test
import org.junit.Assert.assertEquals

class PasswordHelperTest {

    @Test
    fun test_isValidPassword_inputEmptyString_expectedFalse() {
        // Arrange
        val passwordHelper = PasswordHelper()
        // Act
        val result = passwordHelper.isValidPassword("")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun test_isValidPassword_inputInvalidLengthString_expectedFalse() {
        // Arrange
        val passwordHelper = PasswordHelper()
        // Act
        val result = passwordHelper.isValidPassword("abc")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun test_isValidPassword_inputValidString_expectedTrue() {
        // Arrange
        val passwordHelper = PasswordHelper()
        // Act
        val result = passwordHelper.isValidPassword("abcdef")
        // Assert
        assertEquals(true, result)
    }
}