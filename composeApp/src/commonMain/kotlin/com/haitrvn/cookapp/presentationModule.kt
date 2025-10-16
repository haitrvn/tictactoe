package com.haitrvn.cookapp

import com.haitrvn.auth.di.loginModule
import com.haitrvn.data.di.dataModule
import com.haitrvn.domain.domainModule
import com.haitrvn.features.setting.di.settingModule
import com.haitrvn.home.di.homeModule
import com.haitrvn.navigation.di.navigationMode
import com.haitrvn.splash.di.splashModule
import org.koin.dsl.module

val presentationModule = module {
}

val appModule = listOf(
    dataModule,
    navigationMode,
    presentationModule,
    domainModule,

    homeModule,
    loginModule,
    splashModule,
    settingModule,
)
