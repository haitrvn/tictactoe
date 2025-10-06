package com.haitrvn.coreui.state

const val UnknownError = "UNKNOWN_ERROR"

sealed interface UiState<out T> {
    data object Idle : UiState<Nothing>

    data class Loading(val progress: Float? = null) : UiState<Nothing>

    data class Success<T>(
        val data: T,
        val fromCache: Boolean = false
    ) : UiState<T>

    data object Empty : UiState<Nothing>

    data class Error(
        val throwable: Throwable,
        val message: String = throwable.message ?: UnknownError,
        val canRetry: Boolean = true
    ) : UiState<Nothing>

    data class Refreshing<T>(val data: T) : UiState<T>
}
