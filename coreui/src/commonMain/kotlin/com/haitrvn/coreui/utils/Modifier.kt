package com.haitrvn.coreui.utils

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.conditionalClickable(
    onClick: (() -> Unit)?,
    enabled: Boolean = true
) = composed {
    if (onClick != null) {
        clickable(enabled = enabled, onClick = onClick)
    } else {
        this
    }
}