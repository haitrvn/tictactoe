package com.haitrvn.coreui.preview

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.VideoCard
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme

@DevicesPreview
@Composable
fun PreviewVideoCard() {
    CookTheme {
        VideoCard(
            modifier = Modifier.wrapContentSize(),
            star = 4.5f,
            isSaved = false,
            timeStamp = 1000L,
            thumbnailContent = {}
        )
    }
}