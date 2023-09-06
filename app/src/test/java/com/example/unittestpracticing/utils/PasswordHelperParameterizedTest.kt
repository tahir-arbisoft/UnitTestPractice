package com.example.unittestpracticing.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters


@RunWith(value = Parameterized::class)
class PasswordHelperParameterizedTest(val inputString: String, val expected: Boolean) {

    @Test
    fun testIsValidPassword() {
        // Arrange
        val passwordHelper = PasswordHelper()
        // Act
        val result = passwordHelper.isValidPassword(inputString)
        // Assert
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index} : {0} is valid password - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("abcded", true),
                arrayOf("abc", false),
                arrayOf("", false),
            )
        }
    }
}