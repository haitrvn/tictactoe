package com.haitrvn.features.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingViewModel : ViewModel() {
    val uiState: MutableStateFlow<SettingUiState> = MutableStateFlow(SettingUiState.Empty)

    init {
        viewModelScope.launch {
            delay(1000)
            uiState.update {
                SettingUiState(
                    userName = "Nguyen Van A",
                    userAvatar = "https://sm.ign.com/ign_pk/cover/a/avatar-gen/avatar-generations_rpge.jpg",
                    aboutMe = "I am a chef",
                    recipe = 10,
                    followers = 100,
                    following = 100,
                    featuredPhotos = persistentListOf(
                        "https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg",
                        "https://dq5pwpg1q8ru0.cloudfront.net/2022/05/30/07/10/14/5d20bb61-4228-46ca-a3e7-cd024785cbbd/Food.jpg",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpO0Yei24aI8SWNTnWQDKvHKno4l4a4jfJbWJfv9Z9QPdzuSYtDveWMS5JT89lGFGhB94&usqp=CAU",
                        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKyuUCfF_gjGadZyTBeg3l0FdlK6WiVld9CS4AUGXQla-Yd-BjJDXZOqpcbrXvnUhb8xw&usqp=CAU",
                    )
                )
            }
        }
    }
}