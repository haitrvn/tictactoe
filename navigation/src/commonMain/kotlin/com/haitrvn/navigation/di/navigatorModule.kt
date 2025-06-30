package com.haitrvn.navigation.di

import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.NavigatorImpl
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationMode = module {
    single(qualifier = named("HOME")) { param ->
        NavigatorImpl(param.get())
    } bind Navigator::class
    single(qualifier = named("APP")) { param ->
        NavigatorImpl(param.get())
    } bind Navigator::class
}