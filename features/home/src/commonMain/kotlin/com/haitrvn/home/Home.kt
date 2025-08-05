package com.haitrvn.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.TextTitle
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.data.TopData
import org.koin.compose.koinInject

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinInject<HomeViewModel>(),
) {
    HomeWrapper(topData = fakeTopData)
}

private val fakeTopData = listOf(
    TopData(
        imageUrl = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
        title = "Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
        foodType = "Beef"
    ),
    TopData(
        imageUrl = "https://www.themealdb.com/images/media/meals/z0ageb1583189517.jpg",
        title = "Beef Rendang",
        foodType = "Beef"
    ),
    TopData(
        imageUrl = "https://www.themealdb.com/images/media/meals/ursuup1487348423.jpg",
        title = "Big Mac",
        foodType = "Beef"
    ),
    TopData(
        imageUrl = "https://www.themealdb.com/images/media/meals/wxywrq1468235067.jpg",
        title = "Recheado Masala Fish",
        foodType = "Seafood"
    ),
)


@Composable
fun HomeWrapper(
    modifier: Modifier = Modifier,
    onTopClick: (TopData) -> Unit = {},
    topData: List<TopData> = fakeTopData
) {
    val screenHeightFraction = 0.375f

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Header(
                    modifier = Modifier.fillMaxWidth().height(screenHeightFraction * maxHeight),
                    topData = topData
                )
            }
            item {
                Category(modifier = Modifier.fillMaxSize().background(Color.Red))
            }
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    topData: List<TopData> = emptyList(),
) {
    val pagerState = rememberPagerState { 4 }
    CookSurface(modifier = modifier.fillMaxSize()) {
        HorizontalPager(modifier = Modifier.fillMaxSize(), state = pagerState) { page ->
            CookImage(
                modifier = Modifier.fillMaxSize(),
                url = topData[page].imageUrl,
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(alignment = Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                    )
                )
                .padding(CookTheme.contentPadding.small),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {
            TextSmall(text = topData[pagerState.currentPage].foodType, color = CookTheme.colors.onPrimary)
            TextTitle(text = topData[pagerState.currentPage].title, color = CookTheme.colors.onPrimary)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Category(modifier: Modifier = Modifier) {

}

@Composable
fun PopularUser(modifier: Modifier = Modifier) {

}