package com.example.unittestpracticing

import com.example.unittestpracticing.utils.MainCoroutineRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CoroutinesCreatorTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testGetUserName() {
        val testClass = CoroutinesCreator(mainCoroutineRule.dispatcher)

        runTest {
            testClass.getUserName()
        }
    }

    @Test
    fun testGetUser() {
        val testClass = CoroutinesCreator(mainCoroutineRule.dispatcher)

        runTest {
            testClass.getUser()
        }
    }

    @Test
    fun testGetAddress() {
        val testClass = CoroutinesCreator(mainCoroutineRule.dispatcher)

        runTest {
            testClass.getAddress()
        }
    }

    @Test
    fun testGetAddressDetail() {
        val testClass = CoroutinesCreator(mainCoroutineRule.dispatcher)

        runTest {
            testClass.getAddressDetail()
            mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
            assertEquals(true, testClass.globalArg)
        }
    }
}