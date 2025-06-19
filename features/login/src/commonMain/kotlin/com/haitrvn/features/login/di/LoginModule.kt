package com.haitrvn.features.login.di

import com.haitrvn.domain.usecase.UserLoginUseCase
import com.haitrvn.domain.usecase.UserLoginValidationUseCase
import com.haitrvn.features.login.LoginScreen
import com.haitrvn.features.login.LoginViewModel
import com.haitrvn.navigation.Screen
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModule = module {
    singleOf(::UserLoginUseCase)
    singleOf(::UserLoginValidationUseCase)

    viewModelOf(::LoginViewModel)

    singleOf(::LoginScreen) bind Screen.Login::class
}