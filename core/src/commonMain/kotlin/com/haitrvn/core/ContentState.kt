package com.haitrvn.core;

sealed class ContentState<out T> {
  object Loading : ContentState<Nothing>()
  data class Content<out T>(val content: T) : ContentState<T>()
  data class State(val error: AppError) : ContentState<Nothing>()
}

sealed class AppError {
  object NetworkError : AppError()
  object UnknownError : AppError()
}