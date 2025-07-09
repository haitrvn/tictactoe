@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.features.login

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.navigation.Navigator

const val HEADER_CONTENT_SCALE = 0.5f

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        with(sharedTransitionScope) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header(modifier = Modifier.fillMaxWidth().fillMaxHeight(HEADER_CONTENT_SCALE))
                Buttons(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    CookSurface(modifier = modifier, color = Color.Yellow) {
        CookImage(
            modifier = Modifier.fillMaxSize().height(20.dp),
            contentScale = ContentScale.Crop,
            url = "https://static.vecteezy.com/system/resources/previews/013/488/415/non_2x/tasty-fast-food-hand-drawn-for-cute-background-illustration-design-wallpaper-in-pattern-hand-drawn-style-vector.jpg"
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.5f),
                            Color.Black.copy(alpha = 0.5f),
                        )
                    )
//                    Color.Black
                )
        )
    }
}

@Composable
private fun Buttons(modifier: Modifier = Modifier) {
    CookSurface(modifier = modifier, color = Color.Red) {

    }
}