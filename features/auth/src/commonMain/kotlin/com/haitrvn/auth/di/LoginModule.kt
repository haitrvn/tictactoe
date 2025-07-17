package com.haitrvn.auth.di

import com.haitrvn.domain.usecase.UserLoginUseCase
import com.haitrvn.domain.usecase.UserLoginValidationUseCase
import com.haitrvn.auth.LoginViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    singleOf(::UserLoginUseCase)
    singleOf(::UserLoginValidationUseCase)

    viewModelOf(::LoginViewModel)
}