package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.haitrvn.coreui.theme.DesignColors
import com.haitrvn.coreui.theme.Typography
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_icon_back

enum class AvatarSize(val size: Dp, val textStyle: TextStyle) {
    Size96(96.dp, Typography.text3ExtraLargeRegular), // 36px
    Size72(72.dp, Typography.text2ExtraLargeRegular), // 32px
    Size56(56.dp, Typography.textExtraLargeRegular), // 24px
    Size48(48.dp, Typography.textLargeRegular), // 20px
    Size32(32.dp, Typography.textBaseRegular), // 18px
    Size24(24.dp, Typography.textSmallRegular), // 14px
    Size16(16.dp, Typography.textExtraSmallRegular)  // 12px
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

    data class Empty(override val status: AvatarStatus = AvatarStatus.None) : AvatarState
    data class Initial(val initial: String, override val status: AvatarStatus = AvatarStatus.None) : AvatarState
    data class UserPic(val url: String, override val status: AvatarStatus = AvatarStatus.None) : AvatarState
}

@Composable
fun Avatar(
    state: AvatarState,
    size: AvatarSize,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.size(size.size)) {
        // Main Content
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(CircleShape)
                .background(getBackgroundColor(state)),
            contentAlignment = Alignment.Center
        ) {
            when (state) {
                is AvatarState.Empty -> {
                    Image.Normal(
                        source = Res.drawable.core_ui_icon_back,
                        modifier = Modifier.size(size.size * 0.6f)
                    )
                }

                is AvatarState.Initial -> {
                    Text(
                        text = state.initial,
                        style = size.textStyle,
                        color = DesignColors.Blue.Blue500
                    )
                }

                is AvatarState.UserPic -> {
                    Image.Circle(
                        modifier = Modifier.matchParentSize(),
                        source = state.url
                    )
                }
            }
        }

        // Status Overlay
        if (state.status != AvatarStatus.None) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(size.size * 0.3f) // Status size relative to avatar
                    .offset(x = 2.dp, y = 2.dp) // Slight offset
            ) {
                StatusIndicator(status = state.status, modifier = Modifier.matchParentSize())
            }
        }
    }
}

@Composable
private fun getBackgroundColor(state: AvatarState): Color {
    return when (state) {
        is AvatarState.Empty -> DesignColors.BlackAndWhite.Grey200
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

    val icon: ImageVector? = when (status) {
//        AvatarStatus.Editing -> Icons.Default.Edit
//        AvatarStatus.Uploaded -> Icons.Default.Check
//        AvatarStatus.ErrorUpload -> Icons.Default.Close
        else -> null // Active/Inactive are just dots
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(1.dp, DesignColors.BlackAndWhite.White, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (icon != null) {
            Image.Normal(
                source = icon,
                modifier = Modifier.size(10.dp) // Small icon size
            )
        }
    }
}

@Composable
fun AvatarStack(
    avatars: List<AvatarState>,
    size: AvatarSize,
    max: Int = 5,
    modifier: Modifier = Modifier
) {
    val displayAvatars = avatars.take(max)
    val remaining = avatars.size - max

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        displayAvatars.forEachIndexed { index, state ->
            Avatar(
                state = state,
                size = size,
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
                    .size(size.size)
                    .clip(CircleShape)
                    .background(DesignColors.BlackAndWhite.Grey200)
                    .border(2.dp, DesignColors.BlackAndWhite.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+$remaining",
                    style = size.textStyle,
                    color = DesignColors.BlackAndWhite.Grey700
                )
            }
        }
    }
}
