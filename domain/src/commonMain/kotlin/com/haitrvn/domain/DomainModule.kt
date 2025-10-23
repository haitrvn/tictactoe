package com.haitrvn.domain

import com.haitrvn.domain.usecase.SplashUseCase
import com.haitrvn.domain.usecase.UserLoginUseCase
import com.haitrvn.domain.usecase.UserLoginValidationUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::SplashUseCase)
    singleOf(::UserLoginUseCase)
    singleOf(::UserLoginValidationUseCase)
}