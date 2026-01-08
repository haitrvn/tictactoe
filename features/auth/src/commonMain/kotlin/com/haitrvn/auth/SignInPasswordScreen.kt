package com.haitrvn.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.AppButton
import com.haitrvn.coreui.component.OnBackgroundText
import com.haitrvn.coreui.component.AppTextField
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

@Composable
fun SignInPasswordScreen(
    onContinueClick: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        OnBackgroundText(
            text = "Sign in",
            style = Typography.text2ExtraLargeBold,
        )
        Spacer(modifier = Modifier.height(32.dp))
        AppTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(
            text = "Continue",
            onClick = { onContinueClick(password) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OnBackgroundText(
            text = "Forgot Password?",
            style = Typography.textExtraSmallMedium,
            modifier = Modifier.clickable { onForgotPasswordClick() }
        )
    }
}
