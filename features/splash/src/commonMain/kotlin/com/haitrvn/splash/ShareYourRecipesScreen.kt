package com.haitrvn.splash

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.AppIcon
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.Drop
import com.haitrvn.coreui.FillSpace
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.SmoothLinearProgressBar
import com.haitrvn.coreui.TextParagraph2
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import com.haitrvn.splash.model.PageContentUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.koin.compose.viewmodel.koinViewModel

const val BACKGROUND_ALPHA = 0.8f
val PADDING_OUT_SIDES = 16.dp

@Composable
fun SharedYourRecipesScreenWrapper(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    val viewmodel = koinViewModel<SplashViewModel>()
    SharedYourRecipesScreen(
        modifier = modifier,
        listData = viewmodel.uiState.collectAsState().value.listPageContentUi.toImmutableList(),
        goToLogin = {
            navigator.navigate(Auth.Login)
        }
    )
}

@Composable
fun SharedYourRecipesScreen(
    modifier: Modifier = Modifier,
    listData: ImmutableList<PageContentUi> = persistentListOf(PageContentUi.DEFAULT),
    goToLogin: () -> Unit = {},
) {
    Box(modifier = Modifier.fillMaxSize().then(modifier), contentAlignment = Alignment.Center) {
        val pagerState = rememberPagerState(pageCount = { listData.size })
        Drop(modifier = Modifier.fillMaxSize(), hasDrop = false) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                CookImage(
                    modifier.fillMaxSize(),
                    source = listData[page].imageUrl
                )
            }
        }
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            SplashInformation(
                modifier = Modifier.fillMaxSize().padding(
                    top = 40.dp,
                    start = 40.dp,
                    end = 40.dp,
                    bottom = 146.dp
                ),
                pageContentUi = listData[pagerState.currentPage]
            )
            Box(
                modifier = Modifier
                    .padding(
                        end = 16.dp,
                        bottom = 22.dp,
                    )
                    .size(100.dp)
                    .align(Alignment.BottomEnd)
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { goToLogin() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                HeaderText(
                    modifier = Modifier,
                    text = ">",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
            SmoothLinearProgressBar(
                modifier = Modifier.padding(
                    start = 16.dp,
                    bottom = 60.dp,
                ).fillMaxWidth(0.4f)
                    .height(10.dp)
                    .align(Alignment.BottomStart),
                progress = (pagerState.currentPage + 1).toFloat() / pagerState.pageCount.toFloat()
            )
        }
    }
}

@Composable
fun SplashInformation(
    modifier: Modifier,
    pageContentUi: PageContentUi,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom
    ) {
        AppIcon(modifier = Modifier.fillMaxWidth())
        FillSpace()
        HeaderText(
            modifier = Modifier.fillMaxWidth(),
            text = pageContentUi.title,
            color = Color.White,
            fontSize = 50.sp
        )
        MediumSpace(modifier = Modifier.height(10.dp))
        TextParagraph2(
            modifier = Modifier.fillMaxWidth(),
            text = pageContentUi.description,
            color = Color.White,
        )
    }
}
