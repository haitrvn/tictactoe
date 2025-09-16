package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.HeaderText2
import com.haitrvn.coreui.RoundButton
import com.haitrvn.coreui.SmoothLinearProgressBar
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier, navigator: Navigator
) {
    WelcomeScreen(
        modifier = modifier, welcomeUiState = WelcomeUiState(
            login = WelcomePageUi(
                title = "Abc",
                description = "description",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSudTsDqMa_OimGOwDvB5veN7NQ3lyWuhGSVw&s"
            ),
            pages = persistentListOf(
                WelcomePageUi(
                    title = "Abc",
                    description = "description",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSudTsDqMa_OimGOwDvB5veN7NQ3lyWuhGSVw&s"
                ), WelcomePageUi(
                    title = "Abc",
                    description = "description",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSudTsDqMa_OimGOwDvB5veN7NQ3lyWuhGSVw&s"
                ), WelcomePageUi(
                    title = "Abc",
                    description = "description",
                    imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSudTsDqMa_OimGOwDvB5veN7NQ3lyWuhGSVw&s"
                )
            )
        ), goToLogin = { navigator.navigate(Auth.Login) })
}

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    welcomeUiState: WelcomeUiState,
    goToLogin: () -> Unit = {},
) {
    val welcomePages = welcomeUiState.pages
    val pagerState = rememberPagerState { welcomePages.size }
    val isLastPage by remember {
        derivedStateOf { pagerState.currentPage == pagerState.pageCount - 1 }
    }
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier.fillMaxSize().padding(CookTheme.space.screenPadding)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(0.85f)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium),
                state = pagerState
            ) {
                CookImage(
                    modifier = Modifier.fillMaxSize(),
                    source = welcomePages[pagerState.currentPage].imageUrl,
                )
            }
            Box(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium)
                    .background(Color.Black.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(CookTheme.space.medium).fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    HeaderText2(
                        text = welcomePages[pagerState.currentPage].title,
                    )
                    TextParagraph(
                        text = welcomePages[pagerState.currentPage].description,
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().weight(0.15f)
                .padding(top = CookTheme.space.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            SmoothLinearProgressBar(
                progress = ((pagerState.currentPage + 1).toFloat() / pagerState.pageCount.toFloat()).coerceIn(
                    0f, 1f
                ),
                modifier = Modifier.padding(end = CookTheme.space.medium).fillMaxHeight(0.1f)
                    .fillMaxWidth().weight(1f),
            )
            RoundButton(
                modifier = Modifier.fillMaxHeight(0.6f).aspectRatio(1f),
                text = ">"
            ) {
                if (isLastPage) {
                    goToLogin()
                } else {
                    scope.launch {
                        val next =
                            (pagerState.currentPage + 1).coerceAtMost(pagerState.pageCount - 1)
                        pagerState.animateScrollToPage(next)
                    }
                }
            }
        }
    }
}

data class WelcomeUiState(
    val login: WelcomePageUi,
    val pages: ImmutableList<WelcomePageUi>,
)

data class WelcomePageUi(
    val title: String,
    val description: String,
    val imageUrl: String,
)