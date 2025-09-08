package com.haitrvn.coreui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookRoundSurface
import com.haitrvn.coreui.theme.CookTheme
import kotlinx.datetime.Clock
import kotlin.math.abs

@Composable
internal fun BaseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = CookTheme.colors.primary,
    disabledBackgroundColor: Color = CookTheme.colors.primary,
    shape: Shape = CookTheme.shapes.large,
    content: @Composable () -> Unit,
) {
    CookRoundSurface(
        modifier = modifier
            .clickableWithRipple(onClick = onClick, enabled = enabled),
        shape = shape,
        color = if (enabled) backgroundColor else disabledBackgroundColor,
    ) {
        content()
    }
}

@Composable
internal fun BaseSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    enabled: Boolean = true,
    borderColor: Color = CookTheme.colors.primary,
    disabledBorderColor: Color = CookTheme.colors.primary,
    borderWidth: Dp = 2.dp,
    shape: Shape = CookTheme.shapes.large,
    paddingValues: PaddingValues = CookTheme.contentPadding.medium,
    content: @Composable () -> Unit,
) {
    val color = if (enabled) borderColor else disabledBorderColor
    Box(
        modifier = modifier
            .clip(shape)
            .background(Color.Transparent)
            .border(BorderStroke(borderWidth, color), shape)
            .clickableWithRipple(onClick = onClick, enabled = enabled)
            .padding(paddingValues),
        contentAlignment = Alignment.Center

    ) {
        content()
    }
}

@Composable
private fun Modifier.clickableWithRipple(
    enabled: Boolean,
    contentColor: Color = CookTheme.colors.onPrimary,
    debounceTime: Long = 1000L,
    onClick: () -> Unit,
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    return if (enabled) {
        this.composed {
            val clickable = debouncedComposable(debounceTime = debounceTime, onClick = { onClick() })
            this.clickable(
                interactionSource = interactionSource,
                indication = ripple(color = contentColor.copy(alpha = 0.24f)),
                onClick = clickable
            )
        }
    } else {
        this
    }
}

@Composable
inline fun debouncedComposable(crossinline onClick: () -> Unit, debounceTime: Long = 1000L): () -> Unit {
    var lastTimeClicked by remember { mutableStateOf(0L) }
    val onClickLambda: () -> Unit = {
        val now = Clock.System.now().toEpochMilliseconds()
        if (now - lastTimeClicked > debounceTime) {
            onClick()
        }
        lastTimeClicked = now
    }
    return onClickLambda
}

object DebouncedClickable {
    private const val DEFAULT_DELAY_TIME = 500
    private var lastClickTime: Long = 0

    internal fun preform(timeDelay: Int = DEFAULT_DELAY_TIME, action: () -> Unit) {
        if (abs(Clock.System.now().toEpochMilliseconds() - lastClickTime) > timeDelay) {
            action.invoke()
            lastClickTime = Clock.System.now().toEpochMilliseconds()
        }
    }
}

/**
 * The same as [Modifier.clickable] with support to debouncing.
 */
fun Modifier.debouncedClickable(
    debounceTime: Long = 1000L,
    onClick: () -> Unit
): Modifier {
    return this.composed {
        val clickable = debouncedComposable(debounceTime = debounceTime, onClick = { onClick() })
        this.clickable { clickable() }
    }
}