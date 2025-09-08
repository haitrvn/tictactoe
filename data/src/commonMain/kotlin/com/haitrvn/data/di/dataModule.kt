package com.haitrvn.data.di

import com.haitrvn.data.LocalSplashDateSource
import com.haitrvn.data.LocalSplashDateSourceImpl
import com.haitrvn.data.RemoteSplashDateSource
import com.haitrvn.data.RemoteSplashDateSourceImpl
import com.haitrvn.data.SplashRepositoryImpl
import com.haitrvn.data.UserLoginRepositoryImpl
import com.haitrvn.domain.SplashRepository
import com.haitrvn.domain.UserLoginRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::UserLoginRepositoryImpl) bind UserLoginRepository::class
    singleOf(::SplashRepositoryImpl) bind SplashRepository::class
    singleOf(::RemoteSplashDateSourceImpl) bind RemoteSplashDateSource::class
    singleOf(::LocalSplashDateSourceImpl) bind LocalSplashDateSource::class
}