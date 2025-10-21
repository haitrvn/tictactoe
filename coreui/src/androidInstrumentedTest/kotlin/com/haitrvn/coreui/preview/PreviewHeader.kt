package com.haitrvn.coreui.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.component.Header
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.icon_star

@DevicesPreview
@Composable
fun PreviewHeader() {
    CookTheme {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(AppColors.background)
        ) {
            Header(title = "Sample header") { }
            Header(title = "Sample header backable", isBackable = true) { }
            Header(title = "Sample header action icon", icon = Res.drawable.icon_star) { }
        }
    }
}