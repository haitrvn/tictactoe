package com.haitrvn.saved.preview


import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.saved.SavedScreen
import com.haitrvn.saved.SavedScreenUiState
import com.haitrvn.saved.SavedVideoAndRecipe
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        SavedScreen(uiState = SavedScreenUiState(mockSavedVideoAndRecipeList))
    }
}


private val mockSavedVideoAndRecipeList = persistentListOf(
    SavedVideoAndRecipe(
        id = "1",
        title = "Công thức nấu ăn ngon",
        star = 4.5f,
        isSaved = true,
        timeStamp = System.currentTimeMillis(),
        thumbnailUrl = "https://example.com/thumb1.jpg"
    ),
    SavedVideoAndRecipe(
        id = "2",
        title = "Video hướng dẫn làm bánh",
        star = 5.0f,
        isSaved = true,
        timeStamp = System.currentTimeMillis() - 86400000, // 1 day ago
        thumbnailUrl = "https://example.com/thumb2.jpg"
    )
)