package com.haitrvn.core

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FlowExtensionTest {

        @Test
        fun `test flatMapFirst only collects first until completion`() = runTest {
            val events = MutableSharedFlow<Int>()
            val result = mutableListOf<Int>()

            // Start collecting BEFORE emitting events
            val job = launch {
                events
                    .flatMapFirst { value ->
                        flowOf(value)
                    }
                    .collect {
                        result.add(it)
                    }
            }
            delay(50)
            events.emit(1)
            events.emit(2)
            events.emit(3)
            delay(400)
            events.emit(4)
            delay(350)

            job.cancel()

            val expected = listOf(
                1,4
            )
            print("result: $result expected: $expected")
            assertEquals(expected, result)
        }
    }

