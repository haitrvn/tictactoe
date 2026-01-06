package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.haitrvn.coreui.theme.DesignColors
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_icon_back
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewAvatar() {
    Avatar(AvatarState.Initial("HA", AvatarStatus.Uploaded))
}

enum class AvatarStatus {
    None,
    Editing,
    Uploaded,
    UserActive,
    UserInactive,
    ErrorUpload
}

sealed interface AvatarState {
    val status: AvatarStatus

    data class Initial(val initial: String, override val status: AvatarStatus = AvatarStatus.None) :
        AvatarState

    data class UserPic(val url: String, override val status: AvatarStatus = AvatarStatus.None) :
        AvatarState
}

@Composable
fun Avatar(
    state: AvatarState,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    BoxWithConstraints(modifier = modifier.aspectRatio(1f)) {
        val density = LocalDensity.current
        val boxWidth = maxWidth

        // Main Content
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(CircleShape)
                .background(getBackgroundColor(state)),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is AvatarState.Initial -> {
                    val fontSize = with(density) { (boxWidth * 0.4f).toSp() }
                    Text(
                        text = state.initial,
                        color = DesignColors.Blue.Blue500,
                        fontSize = fontSize
                    )
                }

                is AvatarState.UserPic -> {
                    Image.Circle(
                        modifier = Modifier.matchParentSize(),
                        source = state.url,
                        placeholder = Res.drawable.core_ui_icon_back
                    )
                }
            }
        }

        // Status Overlay
        if (state.status != AvatarStatus.None) {
            val indicatorSize = boxWidth * 0.2f
            val radius = with(density) { (boxWidth / 2).toPx() }
            val indicatorSizePx = with(density) { indicatorSize.toPx() }
            val angleRad = PI / 4
            val offsetX = radius * cos(angleRad)
            val offsetY = radius * sin(angleRad)
            val xOffset = with(density) { (radius + offsetX - indicatorSizePx / 2).toFloat().toDp() }
            val yOffset = with(density) { (radius + offsetY - indicatorSizePx / 2).toFloat().toDp() }

            Box(
                modifier = Modifier
                    .size(indicatorSize)
                    .offset(x = xOffset, y = yOffset)
            ) {
                StatusIndicator(status = state.status, modifier = Modifier.matchParentSize())
            }
        }
    }
}

@Composable
private fun getBackgroundColor(state: AvatarState): Color {
    return when (state) {
        is AvatarState.Initial -> DesignColors.Blue.Blue200
        is AvatarState.UserPic -> DesignColors.BlackAndWhite.Grey200 // Placeholder color while loading
    }
}

@Composable
private fun StatusIndicator(status: AvatarStatus, modifier: Modifier = Modifier) {
    val backgroundColor = when (status) {
        AvatarStatus.Editing -> DesignColors.Blue.Blue500
        AvatarStatus.Uploaded -> DesignColors.Success.Green500
        AvatarStatus.UserActive -> DesignColors.Success.Green500
        AvatarStatus.UserInactive -> DesignColors.BlackAndWhite.Grey600
        AvatarStatus.ErrorUpload -> DesignColors.Error.Red500
        else -> Color.Transparent
    }

    val icon: DrawableResource? = when (status) {
        AvatarStatus.Editing -> Res.drawable.core_ui_icon_back
        AvatarStatus.Uploaded -> Res.drawable.core_ui_icon_back
        AvatarStatus.ErrorUpload -> Res.drawable.core_ui_icon_back
        else -> null
    }

    BoxWithConstraints(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        val borderWidth = maxWidth * 0.1f

        Box(
            modifier = Modifier
                .matchParentSize()
                .border(borderWidth, DesignColors.BlackAndWhite.White, CircleShape)
        )

        if (icon != null) {
            Image.Normal(
                source = icon,
                modifier = Modifier.fillMaxSize(0.6f) // Responsive icon size
            )
        }
    }
}

@Composable
fun AvatarStack(
    avatars: List<AvatarState>,
    max: Int = 5,
    modifier: Modifier = Modifier
) {
    val displayAvatars = avatars.take(max)
    val remaining = avatars.size - max

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        displayAvatars.forEachIndexed { index, state ->
            Avatar(
                state = state,
                modifier = Modifier
                    .zIndex((displayAvatars.size - index).toFloat())
                    .offset(x = if (index > 0) (-10).dp * index else 0.dp)
                    .border(2.dp, DesignColors.BlackAndWhite.White, CircleShape)
            )
        }

        if (remaining > 0) {
            Box(
                modifier = Modifier
                    .zIndex(0f)
                    .offset(x = (-10).dp * displayAvatars.size)
                    .clip(CircleShape)
                    .background(DesignColors.BlackAndWhite.Grey200)
                    .border(2.dp, DesignColors.BlackAndWhite.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+$remaining",
                    color = DesignColors.BlackAndWhite.Grey700
                )
            }
        }
    }
}
