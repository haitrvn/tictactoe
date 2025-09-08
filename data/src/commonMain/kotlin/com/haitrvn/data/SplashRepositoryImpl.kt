package com.haitrvn.data

import com.haitrvn.domain.SplashRepository
import com.haitrvn.domain.model.PageContent
import com.haitrvn.domain.model.SplashContent

class SplashRepositoryImpl(
    private val remoteDateSource: RemoteSplashDateSource,
    private val localDateSource: LocalSplashDateSource,
) : SplashRepository {
    override suspend fun invoke(): SplashContent {
        return SplashContent(
            splashScreenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsK8g4zhtM_TszTYUho3dMZ2r3uwS-WLL4mA&s",
            tutorialScreenUrl = fakeData
        )
    }
}

interface RemoteSplashDateSource

class RemoteSplashDateSourceImpl : RemoteSplashDateSource
interface LocalSplashDateSource

class LocalSplashDateSourceImpl : LocalSplashDateSource

val fakeData =
    listOf(
        PageContent(
            "Share Your Recipes",
            "Share your favorite recipes with the world!blablablablablablablablablablablablablablablablablabla",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsK8g4zhtM_TszTYUho3dMZ2r3uwS-WLL4mA&s"
        ),
        PageContent(
            "Discover New Flavors",
            "Explore a wide variety of cuisines and dishes.blablablablablablablablablablablablablablablablablablablablablabla",
            "https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg"
        ),
        PageContent(
            "Cook Like a Pro",
            "Learn new cooking techniques and tips.blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla",
            "https://vietop.edu.vn/wp-content/uploads/2023/07/idioms-chu-de-food.jpg"
        ),
    )