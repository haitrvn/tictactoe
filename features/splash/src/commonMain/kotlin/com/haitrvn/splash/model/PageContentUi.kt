package com.haitrvn.splash.model

import androidx.compose.runtime.Stable

data class SplashUiState(
    val splashScreenUrl: String,
    val listPageContentUi: List<PageContentUi> = emptyList(),
) {
    companion object {
        val DEFAULT = SplashUiState(
            splashScreenUrl = "",
            listPageContentUi = listOf(PageContentUi.DEFAULT),
        )
    }
}

@Stable
data class PageContentUi(
    val title: String,
    val description: String,
    val imageUrl: String,
) {
    companion object {
        val DEFAULT = PageContentUi(
            title = "",
            description = "",
            imageUrl = "",
        )
    }
}