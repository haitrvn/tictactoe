@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.login

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSmallPrimaryButton
import com.haitrvn.coreui.CookSmallText
import com.haitrvn.coreui.CookTitleText
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_welcome_quote
import org.jetbrains.compose.resources.stringResource

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        CookImage(url = "")
        CookTitleText(text = stringResource(Res.string.login_welcome_quote))
        CookSmallText(text = stringResource(Res.string.login_welcome_quote))
        CookSmallPrimaryButton(text = stringResource(Res.string.login_welcome_quote)) {}
        CookSmallPrimaryButton(text = stringResource(Res.string.login_welcome_quote)) {}
        CookSmallPrimaryButton(text = stringResource(Res.string.login_welcome_quote)) {}
        CookSmallText(text = stringResource(Res.string.login_welcome_quote))
    }
}