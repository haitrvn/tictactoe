package com.haitrvn.saved.di

import com.haitrvn.saved.SavedViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val saveModule = module {
    viewModelOf(::SavedViewModel)
}