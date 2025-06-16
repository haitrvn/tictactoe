package com.haitrvn.data.di

import com.haitrvn.data.UserLoginRepositoryImpl
import com.haitrvn.domain.UserLoginRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::UserLoginRepositoryImpl) bind UserLoginRepository::class
}