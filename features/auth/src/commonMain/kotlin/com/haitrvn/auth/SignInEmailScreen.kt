package com.haitrvn.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import com.haitrvn.coreui.component.Heading
import com.haitrvn.coreui.component.Label
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.component.AppButton
import com.haitrvn.coreui.component.AppTextField
import com.haitrvn.coreui.component.SocialButton
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.foundation.clickable

@Composable
fun SignInEmailScreen(
    onContinueClick: (String) -> Unit,
    onCreateAccountClick: () -> Unit,
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
            text = "Sign in",
            style = Typography.text2ExtraLargeBold,
            color = AppColors.onBackground
        )
        Spacer(modifier = Modifier.height(32.dp))
        AppTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email Address"
        )
        Spacer(modifier = Modifier.height(16.dp))
        AppButton(
            text = "Continue",
            onClick = { onContinueClick(email) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Label(
            text = "Don't have an account? Create One",
            style = Typography.textExtraSmallMedium,
            modifier = Modifier.clickable { onCreateAccountClick() },
            color = AppColors.onBackground
        )
        Spacer(modifier = Modifier.height(40.dp))
        SocialButton(
            text = "Continue With Apple",
            icon = ColorPainter(AppColors.onSurface), // Placeholder
            onClick = {}
        )
        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(
            text = "Continue With Google",
            icon = ColorPainter(AppColors.onSurface), // Placeholder
            onClick = {}
        )
        Spacer(modifier = Modifier.height(12.dp))
        SocialButton(
            text = "Continue With Facebook",
            icon = ColorPainter(AppColors.onSurface), // Placeholder
            onClick = {}
        )
    }
}
