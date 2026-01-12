package com.haitrvn.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.haitrvn.coreui.component.Heading
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.AppButton
import com.haitrvn.coreui.component.AppTextField
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

@Composable
fun ForgotPasswordScreen(
    onContinueClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Heading(
            text = "Forgot Password",
            style = Typography.text2ExtraLargeBold,
            color = AppColors.onBackground
        )
        Spacer(modifier = Modifier.height(32.dp))
        AppTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Enter Email Address"
        )
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(
            text = "Continue",
            onClick = { onContinueClick(email) }
        )
    }
}
