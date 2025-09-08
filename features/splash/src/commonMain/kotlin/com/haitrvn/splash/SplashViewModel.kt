package com.haitrvn.splash

import androidx.lifecycle.ViewModel
import com.haitrvn.domain.usecase.SplashUseCase
import com.haitrvn.splash.model.SplashState
import kotlinx.coroutines.flow.MutableStateFlow

class SplashViewModel(
    private val splashUseCase: SplashUseCase
) : ViewModel() {
    val uiState = MutableStateFlow<SplashState>(SplashState(emptyList()))
}