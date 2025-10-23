package com.haitrvn.home.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.Home
import com.haitrvn.home.PopularRecipe
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Column {
            Home(
                trendingVideos = persistentListOf(),
            )
        }
    }
}

@DevicesPreview
@Composable
fun PreviewPopularRecipe() {
    CookTheme {
        Column {
            PopularRecipe()
        }
    }
}