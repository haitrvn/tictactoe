@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.Button
import com.haitrvn.coreui.component.Heading
import com.haitrvn.coreui.component.Image
import com.haitrvn.coreui.component.Input
import com.haitrvn.coreui.component.LargeSpace
import com.haitrvn.coreui.component.MediumSpace
import com.haitrvn.coreui.component.Normal
import com.haitrvn.coreui.component.Paragraph
import com.haitrvn.coreui.component.Filled
import com.haitrvn.coreui.component.SmallSpace
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.utils.ScreenSizeType
import com.haitrvn.coreui.utils.rememberScreenSizeType
import com.haitrvn.coreui.utils.toText
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_login_password
import cookapp.resources.auth.ic_login_socical_apple
import cookapp.resources.auth.ic_login_socical_google
import cookapp.resources.auth.ic_login_user
import cookapp.resources.auth.login_button_login
import cookapp.resources.auth.login_forgot_password
import cookapp.resources.auth.login_logo
import cookapp.resources.auth.login_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    goBack: () -> Unit = {},
    registerWithEmail: () -> Unit = {},
    loginWithEmail: () -> Unit = {},
    loginWithGoogle: () -> Unit = {},
    loginWithApple: () -> Unit = {},
    gotoHome: () -> Unit = {},
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize()
            .padding(Dimensions.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (rememberScreenSizeType() == ScreenSizeType.Large) {
            Image.Normal(
                modifier = Modifier.fillMaxWidth(0.8f).aspectRatio(1f),
                source = Res.drawable.login_logo,
            )
            MediumSpace()
        }
        Text.Heading(text = stringResource(Res.string.login_title))
        MediumSpace()
        Input.Text(
            modifier = Modifier,
            prefixIcon = Res.drawable.ic_login_user, value = email, onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        SmallSpace()
        Input.Text(
            modifier = Modifier.fillMaxWidth(),
            prefixIcon = Res.drawable.ic_login_password,
            suffixIcon = if (isShowPassword) Res.drawable.ic_login_user else Res.drawable.ic_login_password,
            suffixIconClickable = { isShowPassword = !isShowPassword },
            value = password,
            onValueChange = { password = it },
            visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        SmallSpace()
        Text.Paragraph(text = Res.string.login_forgot_password.toText())
        MediumSpace()
        Button.Filled(
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.login_button_login.toText()
        ) {
            gotoHome()
        }
        LargeSpace()
        Box(modifier = Modifier.fillMaxWidth(0.6f).height(1.dp).background(Color.Black))
        LargeSpace()
        Row(
            modifier = Modifier.fillMaxWidth().height(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image.Normal(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                source = Res.drawable.ic_login_socical_google
            )
            Image.Normal(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                source = Res.drawable.ic_login_socical_apple
            )
        }
    }
}