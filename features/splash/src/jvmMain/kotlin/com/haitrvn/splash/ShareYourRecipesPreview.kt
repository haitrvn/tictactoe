package com.haitrvn.splash

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.splash.model.PageContentUi
import kotlinx.collections.immutable.persistentListOf

@Preview
@Composable
private fun ShareYourRecipesPreview() {
    initPreviewImageLoader()

    val pageContent = PageContentUi(
        title = "ABC",
        description = "description Abcdefghiklmn",
        imageUrl = "imageUrl",
    )
    SharedYourRecipesScreen(listData = persistentListOf(pageContent))
}