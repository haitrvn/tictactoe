package com.haitrvn.domain

import com.haitrvn.domain.model.SplashContent

interface SplashRepository {
    suspend operator fun invoke(): SplashContent
}