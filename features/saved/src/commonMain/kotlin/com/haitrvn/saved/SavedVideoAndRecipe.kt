package com.haitrvn.saved

data class SavedVideoAndRecipe(
    val id: String,
    val title: String,
    val star: Float,
    val isSaved: Boolean,
    val timeStamp: Long,
    val thumbnailUrl: String,
)

