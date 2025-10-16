package com.haitrvn.features.setting.di

import com.haitrvn.features.setting.SettingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingModule = module {
    viewModelOf(::SettingViewModel)
}