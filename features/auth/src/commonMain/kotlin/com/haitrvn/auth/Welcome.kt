package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.haitrvn.coreui.TextHeader
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.TextSmall
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_button_start_cooking
import cookapp.resources.auth.login_welcome_app_name
import cookapp.resources.auth.login_welcome_description
import cookapp.resources.auth.login_welcome_quote
import cookapp.resources.auth.login_welcome_quote_question
import org.jetbrains.compose.resources.stringResource

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    navigator: Navigator
) {
    WelcomeWrapper(
        modifier = modifier.fillMaxSize()
    ) { navigator.navigate(Auth.Login) }
}

@Composable
fun WelcomeWrapper(
    modifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        Header(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f))
        Footer(
            modifier = Modifier.fillMaxSize(),
            onStartCookingClick = onStartCookingClick
        )
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    CookSurface(
        modifier = modifier,
        background = {
            CookSurface(shape = RoundedCornerShape(bottomStart = 40.dp)) {
                CookImage(
                    contentScale = ContentScale.Crop,
                    url = "https://wallpapers.com/images/featured/cute-food-vnp4s9nvgi2bmjnx.jpg"
                )
                Box(
                    Modifier.fillMaxWidth().fillMaxHeight(0.5f)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color.White, Color.Transparent),
                                start = Offset(0f, 0f),
                                end = Offset(0f, Float.POSITIVE_INFINITY)
                            )
                        )
                ) {

                }
            }
        })
    {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CookSpace(SpaceSize.LARGE)
            TextApp(text = stringResource(Res.string.login_welcome_app_name))
            TextSmall(text = stringResource(Res.string.login_welcome_quote))
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
        TextHeader(text = stringResource(Res.string.login_welcome_quote_question))
        CookSpace(SpaceSize.SMALL)
        TextParagraph(text = stringResource(Res.string.login_welcome_description))
        CookSpace(SpaceSize.MEDIUM)
        CookPrimaryButton(text = stringResource(Res.string.login_button_start_cooking)) {
            onStartCookingClick()
        }
    }
}