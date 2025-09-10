package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.AppIcon
import com.haitrvn.coreui.Drop
import com.haitrvn.coreui.FillSpace
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.ImageRecipe
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.SmoothLinearProgressBar
import com.haitrvn.coreui.TextParagraph2
import com.haitrvn.coreui.utils.paddingStartHalfWidth
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import com.haitrvn.splash.model.PageContentUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.koin.compose.viewmodel.koinViewModel

const val BACKGROUND_ALPHA = 0.8f
val PADDING_IN_SIDES = 40.dp
val PADDING_OUT_SIDES = 16.dp
val PADDING_BOTTOM_BONUS = 30.dp
val PADDING_START_PROGRESS_INDICATOR = 16.dp
val PADDING_BOTTOM_PROGRESS_INDICATOR = 132.dp
val PADDING_BOTTOM_TEXT = 58.dp

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
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            ImageRecipe(
                modifier.fillMaxSize(),
                source = listData[page].imageUrl
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = BACKGROUND_ALPHA))
        )
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Drop(
                modifier = Modifier.fillMaxSize(),
                padding = PADDING_OUT_SIDES,
            )
            SplashInformation(
                modifier = Modifier.fillMaxSize().padding(
                    top = PADDING_IN_SIDES,
                    start = PADDING_IN_SIDES,
                    end = PADDING_IN_SIDES,
                    bottom = maxWidth / 5 + PADDING_IN_SIDES + PADDING_BOTTOM_BONUS
                ),
                pageContentUi = listData[pagerState.currentPage]
            )
            HeaderText(
                modifier = Modifier
                    .padding(
                        end = PADDING_OUT_SIDES,
                        bottom = PADDING_OUT_SIDES,
                    )
                    .size(maxWidth/5)
                    .align(Alignment.BottomEnd)
                    .clickable { goToLogin() },
                text = ">",
                textAlign = TextAlign.Center,
                color = Color.White,
            )
        }
        SmoothLinearProgressBar(
            modifier = Modifier.padding(
                start = PADDING_START_PROGRESS_INDICATOR,
                bottom = PADDING_BOTTOM_TEXT,
                end = PADDING_BOTTOM_PROGRESS_INDICATOR
            ).fillMaxWidth()
                .height(10.dp)
                .align(Alignment.BottomStart),
            progress = (pagerState.currentPage + 1).toFloat() / pagerState.pageCount.toFloat()
        )

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
