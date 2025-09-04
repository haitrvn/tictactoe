package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.core.round
import com.haitrvn.coreui.AppIcon
import com.haitrvn.coreui.FillSpace
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.HeaderText2
import com.haitrvn.coreui.ImageRecipe
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.TextParagraph2
import kotlinx.coroutines.launch
import androidx.compose.foundation.Canvas
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp

private const val BACKGROUND_ALPHA = 0.8f
private val FRAME_THICKNESS = 20.dp
private val DROP_WIDTH = 90.dp
private val DROP_HEIGHT = 80.dp
private val DROP_OFFSET = 80.dp
private val RECT_SIZE = 80.dp
private val PADDING_ALL_SIDES = 40.dp
private val PADDING_BOTTOM_COLUMN = 105.dp
private val PROGRESS_INDICATOR_HEIGHT = 80.dp
private val PADDING_START_PROGRESS_INDICATOR = 30.dp
private val PADDING_BOTTOM_PROGRESS_INDICATOR = 50.dp
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

val PagerState.currentPageIndex: Int
    get() = this.currentPage + 1

@Composable
fun SmoothLinearProgressBar(
    progress: Float,
    modifier: Modifier = Modifier.height(12.dp),
    trackColor: Color = Color(0x33000000),
    progressColor: Color = Color(0xFF4CAF50),
    cornerRadius: Dp = 999.dp, // 999.dp -> effectively pill shape; we clamp at half-height
    animate: Boolean = true,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 600, easing = FastOutSlowInEasing),
) {
    val coerced = progress.coerceIn(0f, 1f)
    val animated by animateFloatAsState(
        targetValue = coerced,
        animationSpec = if (animate) animationSpec else snap(),
        label = "smoothProgressAnim"
    )

    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val r = minOf(h / 2f, cornerRadius.toPx())

        // Track (unreached segment)
        drawRoundRect(
            color = trackColor,
            size = Size(w, h),
            cornerRadius = CornerRadius(r, r)
        )

        // Fill (reached segment) — keep rounded ends by clipping to the same rounded rect
        val clip = Path().apply {
            addRoundRect(RoundRect(0f, 0f, w, h, CornerRadius(r, r)))
        }
        val reachedW = w * animated
        clipPath(clip) {
            drawRoundRect(
                color = progressColor,
                size = Size(reachedW, h),
                cornerRadius = CornerRadius(r, r)
            )
        }
    }
}

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
        Column(
            modifier = Modifier.fillMaxSize().padding(PADDING_ALL_SIDES)
                .padding(bottom = PADDING_BOTTOM_COLUMN)
        ) {
            AppIcon(modifier = Modifier.fillMaxWidth())
            FillSpace()
            HeaderText(
                modifier = Modifier.fillMaxWidth(),
                text = listData[pagerState.currentPage].title,
                color = Color.White,
            )
            MediumSpace(modifier = Modifier.height(10.dp))
            TextParagraph2(
                modifier = Modifier.fillMaxWidth(),
                text = listData[pagerState.currentPage].description,
                color = Color.White,
            )
        }
        SmoothLinearProgressBar(
            modifier = Modifier
                .height(PROGRESS_INDICATOR_HEIGHT)
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(
                    start = PADDING_START_PROGRESS_INDICATOR,
                    bottom = PADDING_BOTTOM_PROGRESS_INDICATOR
                ),
            progress = (pagerState.currentPageIndex / listData.size.toFloat()).round(1),
            trackColor = Color.Red.copy(alpha = 0.25f),
            progressColor = Color.Red,
            cornerRadius = 999.dp,
        )
        HeaderText2(
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(
                    end = PADDING_BOTTOM_PROGRESS_INDICATOR,
                    bottom = PADDING_BOTTOM_PROGRESS_INDICATOR
                )
                .clickable {
                    scope.launch {
                        if (pagerState.currentPageIndex == listData.size) {
                            goToLogin()
                        } else {
                            pagerState.animateScrollToPage(pagerState.currentPageIndex)
                        }
                    }
                },
            text = ">",
            color = Color.White,
        )
    }
}
