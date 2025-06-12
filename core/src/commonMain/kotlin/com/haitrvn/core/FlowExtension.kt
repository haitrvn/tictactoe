package com.haitrvn.core

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.concurrent.atomics.AtomicBoolean
import kotlin.concurrent.atomics.ExperimentalAtomicApi

fun <T, R> Flow<T>.flatMapFirst(transform: suspend (value: T) -> Flow<R>): Flow<R> =
    map(transform).flattenFirst()

@OptIn(ExperimentalAtomicApi::class)
fun <T> Flow<Flow<T>>.flattenFirst(): Flow<T> = channelFlow<T> {
    val outerScope = this
    val busy = AtomicBoolean(false)

    collect { inner ->
        if (busy.compareAndSet(false, true)) {
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