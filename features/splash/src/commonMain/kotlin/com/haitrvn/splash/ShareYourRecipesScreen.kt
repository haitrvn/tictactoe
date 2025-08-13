package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.ImageRecipe
import com.haitrvn.coreui.TextHeader2
import com.haitrvn.coreui.TextParagraph2
import kotlinx.coroutines.launch

val fakeData =
    listOf(
        PageContent(
            "Share Your Recipes",
            "Share your favorite recipes with the world!",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsK8g4zhtM_TszTYUho3dMZ2r3uwS-WLL4mA&s"
        ),
        PageContent(
            "Discover New Flavors",
            "Explore a wide variety of cuisines and dishes.",
            "https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg"
        ),
        PageContent(
            "Cook Like a Pro",
            "Learn new cooking techniques and tips.",
            "https://vietop.edu.vn/wp-content/uploads/2023/07/idioms-chu-de-food.jpg"
        ),
    )

@Composable
fun SharedYourRecipesScreen(
    modifier: Modifier = Modifier,
    listData: List<PageContent> = fakeData,
    goToLogin: () -> Unit = {},
) {
    val pagerState = rememberPagerState { listData.size }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                Modifier
                    .fillMaxSize()
            ) {
                ImageRecipe(
                    modifier.fillMaxSize(),
                    source = listData[pagerState.currentPage].imageUrl
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.8f))
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawRoundedStrokeFrame(
                    color = Color.White,
                    frameThickness = 20.dp,
                    dropWith = 70.dp,
                    dropHeight = 45.dp,
                    rectWith = 80.dp,
                    rectHeight = 80.dp,
                )
        )
        Column(modifier = Modifier.fillMaxSize().padding(40.dp).padding(bottom = 105.dp)) {
            TextHeader2(
                modifier = Modifier.fillMaxWidth(),
                text = "Appetit",
                textAlign = TextAlign.Center,
                color = Color.White,
            )
            Spacer(modifier = Modifier.weight(1f))
            TextHeader2(
                modifier = Modifier.fillMaxWidth(),
                text = listData[pagerState.currentPage].title,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextParagraph2(
                modifier = Modifier.fillMaxWidth(),
                text = listData[pagerState.currentPage].description,
                color = Color.White,
            )
        }
        LinearProgressIndicator(
            modifier = Modifier
                .height(80.dp)
                .align(Alignment.BottomStart)
                .padding(start = 30.dp, bottom = 50.dp),
            progress = {
                (pagerState.currentPage + 1) / listData.size.toFloat()
            })
        TextHeader2(
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(end = 50.dp, bottom = 50.dp)
                .clickable {
                    scope.launch {
                        if (pagerState.currentPage == listData.size - 1) {
                            goToLogin()
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
            text = ">",
            color = Color.White,
        )
    }
}
