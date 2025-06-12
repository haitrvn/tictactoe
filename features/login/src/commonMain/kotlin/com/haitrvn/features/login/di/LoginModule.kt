package com.haitrvn.features.login.di

import com.haitrvn.features.login.LoginViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val loginModule = module {
    singleOf(::LoginViewModel)
    viewModelOf(::LoginViewModel)
}