package com.example.unittestpracticing.cat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.unittestpracticing.utils.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.given


class CatViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: CatRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_getCuteCats() = runTest {
        given(repository.getCuteCats()).willReturn(emptyList())

        val testClass = CatViewModel(repository)
        testClass.getCuteCats()
        testDispatcher.scheduler.advanceUntilIdle()
        val result = testClass.cuteCats.getOrAwaitValue()
        assertEquals(0, result.size)
    }
}