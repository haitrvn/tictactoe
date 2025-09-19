package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.Drop
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.RoundButton
import com.haitrvn.coreui.SmoothLinearProgressBar
import com.haitrvn.coreui.Text
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
                    title = "Shape You Recipes",
                    description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    imageUrl = "https://media.istockphoto.com/id/1428412216/photo/a-male-chef-pouring-sauce-on-meal.jpg?s=612x612&w=0&k=20&c=8U3mrgWsuB7pB8axtGj89MXRkHDKodEli9F6wKgPT4A="
                ), WelcomePageUi(
                    title = "Learn To Cook",
                    description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    imageUrl = "https://media.istockphoto.com/id/1130934413/photo/close-up-of-the-hands-of-a-male-chef-on-a-black-background-pour-sauce-from-the-spoon-on-the.jpg?s=612x612&w=0&k=20&c=rH1Uq8YDdNSBiefTO3uXPJsyl3B2FZ4BUy0ilcNqbkI="
                ), WelcomePageUi(
                    title = "Become a Master Chef",
                    description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    imageUrl = "https://img.buzzfeed.com/buzzfeed-static/static/2022-01/24/18/asset/eccaba731fd8/sub-buzz-892-1643049112-1.jpg?downsize=700%3A%2A&output-quality=auto&output-format=auto"
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
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            HorizontalPager(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium),
                state = pagerState,
            ) { page ->
                Drop {
                    CookImage(
                        modifier = Modifier.fillMaxSize(),
                        source = welcomePages[page].imageUrl,
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium)
                    .background(Color.Black.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(CookTheme.space.large).fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text.Header(
                        text = welcomePages[pagerState.currentPage].title,
                        color = CookTheme.colors.paragraphReversed,
                    )
                    Text.Paragraph(
                        text = welcomePages[pagerState.currentPage].description,
                        color = CookTheme.colors.paragraphReversed,
                    )
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                .padding(top = CookTheme.space.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SmoothLinearProgressBar(
                progress = ((pagerState.currentPage + 1).toFloat() / pagerState.pageCount.toFloat()).coerceIn(
                    0f, 1f
                ),
                modifier = Modifier.padding(end = CookTheme.space.medium)
                    .height(20.dp)
                    .fillMaxWidth()
                    .weight(1f),
            )
            RoundButton(
                modifier = Modifier.height(60.dp).aspectRatio(1f),
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