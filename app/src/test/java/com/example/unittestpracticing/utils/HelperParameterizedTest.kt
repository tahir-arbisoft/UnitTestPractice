package com.example.unittestpracticing.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(value = Parameterized::class)
class HelperParameterizedTest(val inputStr: String, val expected: Boolean) {

    @Test
    fun testPallindrome() {
        val helper = Helper()

        val result = helper.isPalindrome(inputStr)

        assertEquals(expected, result)
    }

    companion object {

        @JvmStatic
        @Parameters(name = "{index} : {0} is pallindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
            )
        }
    }
}