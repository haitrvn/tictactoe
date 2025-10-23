@file:OptIn(ExperimentalHazeMaterialsApi::class)

package com.haitrvn.coreui.component

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
import com.haitrvn.coreui.theme.Shapes
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.icon_bookmarked
import cookapp.resources.core.ui.icon_play_button
import cookapp.resources.core.ui.icon_star
import cookapp.resources.core.ui.icon_unbookmark
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState

@Composable
fun VideoCard(
    modifier: Modifier,
    star: Float,
    isSaved: Boolean,
    timeStamp: Long,
    title: String,
    thumbnailUrl: Any,
    onSaveClick: (Boolean) -> Unit = {},
    onPlayClick: () -> Unit = {},
    onRateClick: () -> Unit = {},
) {
    val blurState = rememberHazeState()
    Box(
        modifier = modifier.clip(Shapes.rounded),
        contentAlignment = Alignment.Center,
    ) {
        Image.Normal(
            modifier = Modifier.fillMaxSize()
                .hazeSource(blurState)
                .clickable { onPlayClick() },
            source = thumbnailUrl
        )
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Star(
                modifier = Modifier.align(Alignment.TopStart),
                star = star,
                onRateClick = onRateClick,
                blurState = blurState,
            )
            Saved(
                modifier = Modifier.align(Alignment.TopEnd),
                isSaved = isSaved,
                onSaveClick = onSaveClick,
            )
            PlayButton(
                modifier = Modifier,
                onPlayClick = onPlayClick,
                blurState = blurState
            )
            TimeStamp(
                modifier = Modifier.align(Alignment.BottomEnd),
                time = timeStamp,
                blurState = blurState,
            )
        }
    }
}

@Composable
private fun PlayButton(
    modifier: Modifier,
    blurState: HazeState,
    onPlayClick: () -> Unit,
) {
    Image.Normal(
        modifier = modifier.size(48.dp)
            .clip(Shapes.circle)
            .hazeEffect(blurState, style = HazeMaterials.ultraThin())
            .clickable { onPlayClick() },
        source = Res.drawable.icon_play_button
    )
}

@Composable
private fun Saved(
    modifier: Modifier,
    isSaved: Boolean,
    onSaveClick: (Boolean) -> Unit,
) {
    val icon = if (isSaved) Res.drawable.icon_bookmarked else Res.drawable.icon_unbookmark
    Image.Normal(
        modifier = modifier.size(32.dp).clickable { onSaveClick(!isSaved) },
        source = icon
    )
}

@Composable
fun Star(
    modifier: Modifier,
    star: Float,
    blurState: HazeState,
    onRateClick: () -> Unit,
) {
    Row(
        modifier = modifier.wrapContentSize()
            .clip(Shapes.rounded)
            .hazeEffect(blurState, style = HazeMaterials.ultraThin())
            .clickable { onRateClick() }
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image.Normal(modifier = Modifier.size(16.dp), source = Res.drawable.icon_star)
        TinySpace()
        Text.LabelBold(text = star.toString())
    }
}

@Composable
fun TimeStamp(
    modifier: Modifier,
    time: Long,
    blurState: HazeState,
) {
    Row(
        modifier = modifier.wrapContentSize()
            .clip(Shapes.rounded)
            .hazeEffect(blurState, style = HazeMaterials.ultraThin())
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text.Small(text = time.toString())
    }
}