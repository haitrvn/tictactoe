package com.haitrvn.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.OnPrimaryText
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.onboarding.Res
import cookapp.resources.onboarding.bg_onboarding_1
import cookapp.resources.onboarding.bg_onboarding_2
import cookapp.resources.onboarding.bg_onboarding_3
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

data class OnboardingPage(
    val image: DrawableResource,
    val title: String,
    val description: String
)

@Preview
@Composable
fun PreviewOnboardingScreenLight() {
    CookTheme(systemIsDark = false) {
        OnboardingScreen(onFinish = {})
    }
}

@Preview
@Composable
fun PreviewOnboardingScreenDark() {
    CookTheme(systemIsDark = true) {
        OnboardingScreen(onFinish = {})
    }
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onFinish: () -> Unit
) {
    val pages = listOf(
        OnboardingPage(
            image = Res.drawable.bg_onboarding_1,
            title = "Share Your\nRecipes",
            description = "Lorem ipsum dolor sit amet, consectetur elit, sed do eiusmod tempor incididunt ut."
        ),
        OnboardingPage(
            image = Res.drawable.bg_onboarding_2,
            title = "Learn to\nCook",
            description = "Lorem ipsum dolor sit amet, consectetur elit, sed do eiusmod tempor incididunt ut."
        ),
        OnboardingPage(
            image = Res.drawable.bg_onboarding_3,
            title = "Become a\nMaster Chef",
            description = "Lorem ipsum dolor sit amet, consectetur elit, sed do eiusmod tempor incididunt ut."
        )
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Box(modifier = modifier.fillMaxSize().background(AppColors.background)) {
        // Layer 1: ViewPager displaying images
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { pageIndex ->
            Image(
                painter = painterResource(pages[pageIndex].image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Layer 2: Canvas layer with cutout
        val backgroundColor = AppColors.background
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    compositingStrategy = CompositingStrategy.Offscreen
                }
        ) {
            // Draw the background color
            drawRect(color = backgroundColor)

            // Draw the cutout (hole)
            // Temporarily a rounded rectangle in the middle/top area
            // Adjusting size and position to roughly match where the image should be seen
            val cutoutWidth = size.width * 0.8f
            val cutoutHeight = size.height * 0.6f
            val cutoutLeft = (size.width - cutoutWidth) / 2
            val cutoutTop = size.height * 0.1f // Start 10% from top

            drawRoundRect(
                color = Color.Transparent,
                topLeft = Offset(cutoutLeft, cutoutTop),
                size = Size(cutoutWidth, cutoutHeight),
                cornerRadius = CornerRadius(40.dp.toPx(), 40.dp.toPx()),
                blendMode = BlendMode.Clear
            )
        }

        // Layer 3: Text content and Controls
        Box(modifier = Modifier.fillMaxSize()) {
            val currentPage = pages[pagerState.currentPage]

            // Text Content
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 160.dp, start = 24.dp, end = 24.dp)
            ) {
                OnPrimaryText(
                    text = currentPage.title,
                )
                Spacer(modifier = Modifier.height(16.dp))
                OnPrimaryText(
                    text = currentPage.description,
                )
            }

            // Bottom Control Section
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 40.dp, start = 24.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Pager Indicators
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(pages.size) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) AppColors.tertiary else AppColors.surface
                        val width = if (pagerState.currentPage == iteration) 24.dp else 8.dp
                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(width)
                                .clip(CircleShape)
                                .background(color)
                        )
                    }
                }
            }

            // Next Button
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp, end = 24.dp) // Adjusted position
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(AppColors.onBackground)
                    .clickable {
                        if (pagerState.currentPage < pages.size - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onFinish()
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                OnPrimaryText(">")
            }
        }
    }
}
