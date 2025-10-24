package com.haitrvn.home.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.Home
import com.haitrvn.home.PopularRecipe
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewButton() {
    initPreviewImageLoader()
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
    initPreviewImageLoader()
    CookTheme {
        Column(modifier = Modifier.size(150.dp, 231.dp)) {
            PopularRecipe(
                title = "Pepper sweetcorn ramen",
                time = "10 minutes",
                isSaved = true,
                recipeImageUrl = "",
                onBookmarkClick = {},
            )
        }
    }
}