package com.haitrvn.coreui.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

inline fun <T, R> UiState<T>.map(transform: (T) -> R): UiState<R> = when (this) {
    UiState.Idle -> UiState.Idle
    is UiState.Loading -> UiState.Loading(progress)
    is UiState.Success -> UiState.Success(transform(data), fromCache)
    UiState.Empty -> UiState.Empty
    is UiState.Error -> UiState.Error(throwable, message, canRetry)
    is UiState.Refreshing -> UiState.Refreshing(transform(data))
}

inline fun <T> UiState<T>.fold(
    onIdle: () -> Unit = {},
    onLoading: (Float?) -> Unit = {},
    onSuccess: (T, Boolean) -> Unit,
    onEmpty: () -> Unit = {},
    onError: (Throwable, String, Boolean) -> Unit,
    onRefreshing: (T) -> Unit = {}
) {
    when (this) {
        UiState.Idle -> onIdle()
        is UiState.Loading -> onLoading(progress)
        is UiState.Success -> onSuccess(data, fromCache)
        UiState.Empty -> onEmpty()
        is UiState.Error -> onError(throwable, message, canRetry)
        is UiState.Refreshing -> onRefreshing(data)
    }
}

val <T> UiState<T>.dataOrNull: T?
    get() = (this as? UiState.Success<T>)?.data ?: (this as? UiState.Refreshing<T>)?.data

fun <T> Flow<T>.asUiState(
    emitLoading: Boolean = true,
    emptyCheck: (T) -> Boolean = { false },
    fromCache: Boolean = false
): Flow<UiState<T>> = this
    .map<T, UiState<T>> { value ->
        if (emptyCheck(value)) UiState.Empty else UiState.Success(value, fromCache)
    }
    .onStart { if (emitLoading) emit(UiState.Loading()) }
    .catch { e -> emit(UiState.Error(e)) }
