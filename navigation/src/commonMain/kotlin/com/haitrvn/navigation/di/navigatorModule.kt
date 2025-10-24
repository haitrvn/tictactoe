package com.haitrvn.navigation.di


import org.koin.dsl.module

val navigationMode = module {
    //Singleton + recomposition -> crash (navController not change)

}