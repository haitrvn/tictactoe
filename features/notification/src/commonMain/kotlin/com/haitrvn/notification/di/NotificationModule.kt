package com.haitrvn.notification.di

import com.haitrvn.notification.NotificationViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val notificationModule = module {
    viewModelOf(::NotificationViewModel)
}