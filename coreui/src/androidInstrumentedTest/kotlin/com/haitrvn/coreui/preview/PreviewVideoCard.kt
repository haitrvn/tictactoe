package com.haitrvn.coreui.preview

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.component.VideoCard
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme

@DevicesPreview
@Composable
fun PreviewVideoCard() {
    CookTheme {
        VideoCard(
            modifier = Modifier.wrapContentSize(),
            star = 4.5f,
            isSaved = true,
            timeStamp = 1000L,
            title = "title",
            thumbnailUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpK1noS9RwpA351YDfG9dRCvSON-j5nZHU0A&s"
        )
    }
}