package com.haitrvn.coreui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

@Composable
fun Modifier.doIf(
    condition: Boolean,
    modifier: Modifier.() -> Modifier
): Modifier {
    return if (condition) this.then(modifier(this)) else this
}

@Stable
fun Modifier.paddingStartHalfWidth(): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val paddingStart = (placeable.width / 2)
    val width = placeable.width
    val height = placeable.height
    layout(width, height) {
        placeable.place(x = paddingStart, y = 0)
    }
}

@Stable
fun Modifier.paddingTopHalfWidth(): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    val paddingTop = (placeable.height / 2)
    val width = placeable.width
    val height = placeable.height
    layout(width, height) {
        placeable.place(x = 0, y = paddingTop)
    }
}