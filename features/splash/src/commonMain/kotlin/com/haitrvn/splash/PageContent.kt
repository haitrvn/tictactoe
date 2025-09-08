package com.haitrvn.splash

import androidx.compose.runtime.Stable

@Stable
data class PageContent(
    val title: String,
    val description: String,
    val imageUrl: String,
)