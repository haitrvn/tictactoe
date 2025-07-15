@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.features.login

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookHeaderText
import com.haitrvn.coreui.CookTitleText
import com.haitrvn.coreui.CookParagraphText
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookBigPrimaryButton
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_button_start_cooking
import cookapp.resources.auth.login_welcome_app_name
import cookapp.resources.auth.login_welcome_description
import cookapp.resources.auth.login_welcome_quote
import cookapp.resources.auth.login_welcome_quote_question
import org.jetbrains.compose.resources.stringResource

const val HEADER_CONTENT_SCALE = 0.5f

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    CookSurface(
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
                Header(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(HEADER_CONTENT_SCALE),
                    url = "https://cdn.attractionsvietnam.com/uploads/2024/03/gioi-thieu-mon-pho-bo-1024x683-1.jpg"
                )
                Buttons(modifier = Modifier.fillMaxSize()) {
                    navigator.navigate(Auth.Login)
                }
            }
        }
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    url: String,
) {
    CookSurface(
        modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(bottomStart = 50.dp)
    ) {
        CookImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            url = url
        )
        CookSurface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.5f),
                            Color.Transparent,
                        )
                    )
                ),
            color = Color.Transparent,
            content = {}
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CookHeaderText(text = stringResource(Res.string.login_welcome_app_name))
            CookParagraphText(text = stringResource(Res.string.login_welcome_quote))
        }
    }
}

@Composable
private fun Buttons(
    modifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit
) {
    Column() {
        CookTitleText(text = stringResource(Res.string.login_welcome_quote_question))
        CookTitleText(text = stringResource(Res.string.login_welcome_description))
        CookBigPrimaryButton(text = stringResource(Res.string.login_button_start_cooking)) {
            onStartCookingClick()
        }
    }
}