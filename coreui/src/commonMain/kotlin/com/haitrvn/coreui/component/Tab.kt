package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.theme.Shapes

@Composable
fun Tab(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    text: String,
    onTabSelected: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(Shapes.rounded)
            .background(
                if (isSelected) AppColors.primary else Color.Transparent
            )
            .clickable { onTabSelected() }
            .padding(vertical = Dimensions.small, horizontal = Dimensions.medium),
        contentAlignment = Alignment.Center
    ) {
        Text.SmallBold(
            text = text,
            color = if (isSelected) AppColors.onPrimary else AppColors.primary.copy(alpha = 0.7f)
        )
    }
}