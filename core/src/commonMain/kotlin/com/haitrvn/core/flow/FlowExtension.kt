package com.haitrvn.core.flow

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

fun <T, R> Flow<T>.flatMapFirst(transform: suspend (value: T) -> Flow<R>): Flow<R> =
    map(transform).flattenFirst()

@OptIn(ExperimentalAtomicApi::class)
fun <T> Flow<Flow<T>>.flattenFirst(): Flow<T> = channelFlow<T> {
    val outerScope = this
    val busy = AtomicBoolean(false)

    collect { inner ->
        if (busy.compareAndSet(expectedValue = false, newValue = true)) {
            launch(start = CoroutineStart.UNDISPATCHED) {
                try {
                    inner.collect { send(it) }
                    busy.store(false)
                } catch (e: CancellationException) {
                    // cancel outer scope on cancellation exception, too
                    outerScope.cancel(e)
                }
            }
        }
    }
}