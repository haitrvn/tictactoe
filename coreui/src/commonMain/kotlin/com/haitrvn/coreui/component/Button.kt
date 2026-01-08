package com.haitrvn.coreui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.theme.Typography
import com.haitrvn.coreui.component.OnPrimaryText
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun PreviewAppButton() {
    CookTheme(systemIsDark = true) {
        AppButton(
            text = "Login",
            onClick = {}
        )
    }
}


@Composable
fun AppButton(
    text: String = "",
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = AppColors.primary,
    contentColor: Color = AppColors.onPrimary,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp),
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        OnPrimaryText(
            text = text,
            style = Typography.textMediumSmallMedium
        )
    }
}
