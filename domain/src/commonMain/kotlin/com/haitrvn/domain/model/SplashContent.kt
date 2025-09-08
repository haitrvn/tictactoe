package com.haitrvn.domain.model

data class SplashContent(
    val splashScreenUrl: String,
    val tutorialScreenUrl: List<PageContent>,
)

data class PageContent(
    val title: String,
    val description: String,
    val imageUrl: String,
)