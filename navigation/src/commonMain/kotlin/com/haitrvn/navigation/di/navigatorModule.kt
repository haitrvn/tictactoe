package com.haitrvn.navigation.di

import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.NavigatorImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val navigationMode = module {
    //Singleton + recomposition -> crash (navController not change)
    factory { param ->
        NavigatorImpl(param.get())
    } bind Navigator::class
}