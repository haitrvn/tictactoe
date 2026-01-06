package com.haitrvn.cookapp

import com.haitrvn.data.di.dataModule
import com.haitrvn.domain.domainModule
import com.haitrvn.navigation.ReloadViewModel
import com.haitrvn.navigation.di.navigationMode
import com.haitrvn.splash.di.splashModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::ReloadViewModel)
}

val appModule = listOf(
    dataModule,
    navigationMode,
    presentationModule,
    domainModule,
    splashModule,
)
