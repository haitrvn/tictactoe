package com.haitrvn.coreui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

@Composable
fun SocialButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    containerColor: Color = AppColors.surface,
    contentColor: Color = AppColors.onSurface,
) {
    Box(
        modifier = modifier
            .then(if (text != null) Modifier.fillMaxWidth() else Modifier.size(width = 160.dp, height = 80.dp))
            .height(if (text != null) 56.dp else 80.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(containerColor)
            .clickable(onClick = onClick)
            .padding(if (text != null) PaddingValues(horizontal = 16.dp) else PaddingValues(0.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (text != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                AppText(
                    text = text,
                    style = Typography.textMediumSmallMedium,
                    color = contentColor
                )
                Spacer(modifier = Modifier.weight(1.2f))
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
