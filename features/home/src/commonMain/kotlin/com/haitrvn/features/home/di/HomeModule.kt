package com.haitrvn.features.home.di

import com.haitrvn.domain.usecase.UserLoginUseCase
import com.haitrvn.domain.usecase.UserLoginValidationUseCase
import com.haitrvn.features.home.HomeViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    singleOf(::UserLoginUseCase)
    singleOf(::UserLoginValidationUseCase)

    viewModelOf(::HomeViewModel)
}