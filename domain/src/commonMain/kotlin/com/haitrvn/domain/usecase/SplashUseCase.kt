package com.haitrvn.domain.usecase

import com.haitrvn.domain.SplashRepository
import com.haitrvn.domain.model.SplashContent

class SplashUseCase(
    private val splashRepository: SplashRepository
) {
    suspend operator fun invoke(): SplashContent {
        return splashRepository.invoke()
    }
}