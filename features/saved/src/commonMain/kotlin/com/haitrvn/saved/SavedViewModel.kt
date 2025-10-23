package com.haitrvn.saved

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.time.Clock

class SavedViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<SavedScreenUiState> =
        MutableStateFlow(SavedScreenUiState(mockSavedVideoAndRecipeList))
    val uiState = _uiState.asStateFlow()
}

private val mockSavedVideoAndRecipeList = persistentListOf(
    SavedVideoAndRecipe(
        id = "1",
        title = "Công thức nấu ăn ngon",
        star = 4.5f,
        isSaved = true,
        timeStamp = 1000L,
        thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRY3cOryhn3_YO1AyGKZTg1zLlk5QubdUyoKw&s"
    ),
    SavedVideoAndRecipe(
        id = "2",
        title = "Video hướng dẫn làm bánh",
        star = 5.0f,
        isSaved = true,
        timeStamp = 1000L, // 1 day ago
        thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjY0SHHdRkZEpjyZcqcVVJ_0O3Qw3d0piUZw&s"
    )
)