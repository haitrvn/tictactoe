package com.haitrvn.navigation.di

import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.NavigatorImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationMode = module {
    single { param ->
        NavigatorImpl(param.get())
    } bind Navigator::class
}