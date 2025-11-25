package com.haitrvn.data

import com.haitrvn.domain.SplashRepository
import com.haitrvn.domain.model.PageContent
import com.haitrvn.domain.model.SplashContent

class SplashRepositoryImpl(
    private val remoteDateSource: RemoteSplashDateSource,
    private val localDateSource: LocalSplashDateSource,
) : SplashRepository {
    override suspend fun invoke(): SplashContent {
        TODO()
    }
}

interface RemoteSplashDateSource

class RemoteSplashDateSourceImpl : RemoteSplashDateSource
interface LocalSplashDateSource

class LocalSplashDateSourceImpl : LocalSplashDateSource