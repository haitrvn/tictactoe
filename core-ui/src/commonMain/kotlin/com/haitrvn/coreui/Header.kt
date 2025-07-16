package com.haitrvn.coreui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.core_ui_icon_back

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    isBackable: Boolean = false,
    onBack: () -> Unit = {}
) {
    Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        if (isBackable) {
            CookImage(
                modifier = Modifier.clickable {
                    onBack()
                },
                drawableResource = Res.drawable.core_ui_icon_back
            )
        }
        CookTitleText(text = title)
    }
}