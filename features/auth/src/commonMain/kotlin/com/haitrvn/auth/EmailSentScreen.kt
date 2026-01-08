package com.haitrvn.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import com.haitrvn.coreui.component.OnBackgroundText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.AppButton
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

@Composable
fun EmailSentScreen(
    onReturnToLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = ColorPainter(AppColors.primary), // Placeholder for the email icon
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        OnBackgroundText(
            text = "We Sent you an Email to reset your password.",
            style = Typography.textLargeBold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        AppButton(
            text = "Return to Login",
            onClick = { onReturnToLoginClick() },
            modifier = Modifier.padding(horizontal = 40.dp)
        )
    }
}
