package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import com.haitrvn.splash.model.PageContent
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import org.koin.compose.viewmodel.koinViewModel

const val BACKGROUND_ALPHA = 0.8f
val PADDING_ALL_SIDES = 32.dp
val PADDING_BOTTOM_COLUMN = 130.dp
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
        listData = viewmodel.uiState.collectAsState().value.listPageContent.toImmutableList(),
        goToLogin = {
            navigator.navigate(Auth.Login)
        }
    )
}

@Composable
fun SharedYourRecipesScreen(
    modifier: Modifier = Modifier,
    listData: ImmutableList<PageContent> = persistentListOf(),
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
        Drop(modifier = Modifier.fillMaxSize())
        SplashInformation(
            modifier = Modifier.fillMaxSize().padding(PADDING_ALL_SIDES)
                .padding(bottom = PADDING_BOTTOM_COLUMN),
//            index = pagerState.currentPage,
            pageContent = listData[pagerState.currentPage]
        )
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
        HeaderText(
            modifier = Modifier.align(Alignment.TopEnd).padding(
                end = PADDING_BOTTOM_TEXT,
                bottom = PADDING_BOTTOM_TEXT
            ).clickable { goToLogin() },
            text = ">",
            color = Color.White,
        )
    }
}

@Composable
fun SplashInformation(
    modifier: Modifier,
    pageContent: PageContent,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(PADDING_ALL_SIDES)
            .padding(bottom = PADDING_BOTTOM_COLUMN),
        verticalArrangement = Arrangement.Bottom
    ) {
        AppIcon(modifier = Modifier.fillMaxWidth())
        FillSpace()
        HeaderText(
            modifier = Modifier.fillMaxWidth(),
            text = pageContent.title,
            color = Color.White,
            fontSize = 50.sp
        )
        MediumSpace(modifier = Modifier.height(10.dp))
        TextParagraph2(
            modifier = Modifier.fillMaxWidth(),
            text = pageContent.description,
            color = Color.White,
        )
    }
}
