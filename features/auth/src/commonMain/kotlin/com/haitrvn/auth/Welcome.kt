@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookPrimaryButton
import com.haitrvn.coreui.CookSpace
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.SpaceSize
import com.haitrvn.coreui.TextApp
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_button_start_cooking
import cookapp.resources.auth.login_welcome_app_name
import cookapp.resources.auth.login_welcome_description
import cookapp.resources.auth.login_welcome_quote
import cookapp.resources.auth.login_welcome_quote_question

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    with(sharedTransitionScope) {
        val sharedImageModifier = Modifier.sharedBounds(
            sharedContentState = rememberSharedContentState(key = "mainImage"),
            animatedVisibilityScope = animatedVisibilityScope,
        )
        WelcomeWrapper(
            modifier = modifier.fillMaxSize(),
            sharedImageModifier = sharedImageModifier,
            onStartCookingClick = { navigator.navigate(Auth.Login) },
        )
    }
}

@Composable
fun WelcomeWrapper(
    modifier: Modifier = Modifier,
    sharedImageModifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        Header(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f),
            sharedImageModifier = sharedImageModifier
        )
        Footer(
            modifier = Modifier.fillMaxSize(),
            onStartCookingClick = onStartCookingClick
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    sharedImageModifier: Modifier = Modifier,
) {
    CookSurface(
        modifier = modifier,

        ) {
        CookImage(
            modifier = Modifier.fillMaxSize().then(sharedImageModifier)
                .clip(RoundedCornerShape(bottomStart = 30.dp)),
            url = "https://wallpapers.com/images/featured/cute-food-vnp4s9nvgi2bmjnx.jpg",
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomCenter,
        )
        CookSurface(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White, Color.Transparent),
                        start = Offset(0f, 0f),
                        end = Offset(0f, Float.POSITIVE_INFINITY)
                    )
                ),
            color = Color.Transparent,
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CookSpace(SpaceSize.LARGE)
            TextApp(text = Res.string.login_welcome_app_name.toText())
            TextSmall(text = Res.string.login_welcome_quote.toText())
        }
    }
}

@Composable
private fun Footer(
    modifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CookSpace(SpaceSize.LARGE)
        HeaderText(text = Res.string.login_welcome_quote_question.toText())
        CookSpace(SpaceSize.SMALL)
        TextSmall(text = Res.string.login_welcome_description.toText())
        CookSpace(SpaceSize.MEDIUM)
        CookPrimaryButton(text = Res.string.login_button_start_cooking.toText()) {
            onStartCookingClick()
        }
    }
}