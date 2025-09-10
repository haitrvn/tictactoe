package com.haitrvn.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haitrvn.domain.model.PageContent
import com.haitrvn.domain.model.SplashContent
import com.haitrvn.domain.usecase.SplashUseCase
import com.haitrvn.splash.model.PageContentUi
import com.haitrvn.splash.model.SplashUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SplashViewModel(
    private val splashUseCase: SplashUseCase
) : ViewModel() {
    val uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.DEFAULT)

    init {
        viewModelScope.launch {
            uiState.update {
                splashUseCase().mapToUi()
            }
        }
    }

}

fun SplashContent.mapToUi() = SplashUiState(
    splashScreenUrl = this.splashScreenUrl,
    listPageContentUi = this.tutorialScreenUrl.map { it.mapToUi() },
)

private fun PageContent.mapToUi() = PageContentUi(
    title = title,
    description = description,
    imageUrl = imageUrl,
)