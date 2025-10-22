package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Shapes
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_icon_back
import cookapp.resources.core.ui.icon_bookmarked
import cookapp.resources.core.ui.icon_star
import cookapp.resources.core.ui.icon_unbookmark

@Composable
fun VideoCard(
    modifier: Modifier,
    star: Float,
    isSaved: Boolean,
    timeStamp: Long,
    title: String,
    thumbnailUrl: Any,
) {
    Box(
        modifier = modifier.clip(Shapes.rounded),
        contentAlignment = Alignment.Center
    ) {
        Image.Normal(modifier = Modifier.fillMaxSize(), source = thumbnailUrl)
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Star(modifier = Modifier.align(Alignment.TopStart), star = star)
            Saved(modifier = Modifier.align(Alignment.TopEnd), isSaved = isSaved)
            PlayButton(modifier = Modifier, onPlayClick = {})
            TimeStamp(modifier = Modifier.align(Alignment.BottomEnd), time = timeStamp)
        }
    }
}

@Composable
fun PlayButton(
    modifier: Modifier,
    onPlayClick: () -> Unit
) {
    Image.Normal(
        modifier = modifier.size(48.dp)
            .clip(Shapes.circle)
            .background(AppColors.onPrimary)
            .clickable { onPlayClick() },
        source = Res.drawable.core_ui_icon_back
    )
}

@Composable
fun Saved(
    modifier: Modifier,
    isSaved: Boolean
) {
    if (isSaved) {
        Image.Normal(modifier = modifier.size(32.dp), source = Res.drawable.icon_bookmarked)
    } else {
        Image.Normal(
            modifier = modifier.size(32.dp),
            source = Res.drawable.icon_unbookmark
        )
    }
}

@Composable
fun Star(
    modifier: Modifier,
    star: Float,
) {
    Row(
        modifier = modifier.wrapContentSize()
            .clip(Shapes.rounded)
            .background(AppColors.secondary)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image.Normal(modifier = Modifier.size(16.dp), source = Res.drawable.icon_star)
        TinySpace()
        Text.Paragraph(text = star.toString())
    }
}

@Composable
fun TimeStamp(
    modifier: Modifier,
    time: Long,
) {
    Row(
        modifier = modifier.wrapContentSize()
            .clip(Shapes.rounded)
            .background(AppColors.secondary)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text.Paragraph(text = time.toString())
    }
}