package com.haitrvn.coreui.utils

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun StringResource.toText(): String {
    return stringResource(this)
}