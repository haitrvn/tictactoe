package com.haitrvn.splash.model

import androidx.compose.runtime.Stable

data class SplashState(
    val listPageContent: List<PageContent> = emptyList(),
)

@Stable
data class PageContent(
    val title: String,
    val description: String,
    val imageUrl: String,
)