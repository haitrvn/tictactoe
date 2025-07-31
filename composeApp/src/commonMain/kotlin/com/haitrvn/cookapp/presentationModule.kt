package com.haitrvn.cookapp

import com.haitrvn.auth.di.loginModule
import com.haitrvn.data.di.dataModule
import com.haitrvn.home.di.homeModule
import com.haitrvn.navigation.ReloadViewModel
import com.haitrvn.navigation.di.navigationMode
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::ReloadViewModel)
}

val appModule = listOf(homeModule, loginModule, dataModule, navigationMode, presentationModule)
