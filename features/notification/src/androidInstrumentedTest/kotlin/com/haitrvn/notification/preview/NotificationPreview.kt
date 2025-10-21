package com.haitrvn.notification.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.notification.NotificationScreen
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Column {
            NotificationScreen(
                modifier = Modifier,
                notifications = persistentListOf()
            )
        }
    }
}