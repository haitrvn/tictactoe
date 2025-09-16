package com.haitrvn.coreui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AppIcon(modifier: Modifier = Modifier, color: Color = Color.White) {
    HeaderText2(
        modifier = modifier.fillMaxWidth(),
        text = "Appetit",
        textAlign = TextAlign.Center,
        color = color,
    )
}