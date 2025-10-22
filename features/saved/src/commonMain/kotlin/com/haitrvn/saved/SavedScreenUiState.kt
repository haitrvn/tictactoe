package com.haitrvn.saved

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class SavedScreenUiState(
    val listSaved: PersistentList<SavedVideoAndRecipe>,
)