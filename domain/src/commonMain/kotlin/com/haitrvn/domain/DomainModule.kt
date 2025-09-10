package com.haitrvn.domain

import com.haitrvn.domain.usecase.SplashUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SplashUseCase)
}