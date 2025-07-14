package com.haitrvn.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookBigPrimaryButton
import org.jetbrains.compose.resources.stringResource
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_button_start_cooking
import cookapp.resources.auth.login_welcome_app_name
import cookapp.resources.auth.login_welcome_description
import cookapp.resources.auth.login_welcome_quote
import cookapp.resources.auth.login_welcome_quote_question
import com.haitrvn.coreui.CookDisplayText
import com.haitrvn.coreui.CookTitleText
import com.haitrvn.coreui.CookBodyText

@Composable
fun Welcome2(
    modifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit = {},
) {
    CookSurface(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WelcomeHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                url = "https://cdn.attractionsvietnam.com/uploads/2024/03/gioi-thieu-mon-pho-bo-1024x683-1.jpg"
            )
            Spacer(modifier = Modifier.height(24.dp))
            WelcomeContent(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            WelcomeButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                onClick = onStartCookingClick
            )
        }
    }
}

@Composable
private fun WelcomeHeader(
    modifier: Modifier = Modifier,
    url: String,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))
    ) {
        CookImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            url = url
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.5f),
                            Color.Transparent,
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CookDisplayText(text = stringResource(Res.string.login_welcome_app_name))
            Spacer(modifier = Modifier.height(8.dp))
            CookBodyText(text = stringResource(Res.string.login_welcome_quote))
        }
    }
}

@Composable
private fun WelcomeContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CookTitleText(text = stringResource(Res.string.login_welcome_quote_question))
        Spacer(modifier = Modifier.height(8.dp))
        CookTitleText(text = stringResource(Res.string.login_welcome_description))
    }
}

@Composable
private fun WelcomeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    CookBigPrimaryButton(
        text = stringResource(Res.string.login_button_start_cooking),
        modifier = modifier,
        onClick = onClick
    )
} 