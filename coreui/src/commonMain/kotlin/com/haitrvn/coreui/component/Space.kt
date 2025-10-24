package com.haitrvn.coreui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.haitrvn.coreui.theme.Dimensions

@Composable
fun TinySpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.tiny))
}

@Composable
fun SmallSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.small))
}

@Composable
fun MediumSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.medium))
}

@Composable
fun LargeSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.large))
}

@Composable
fun CustomSpace(size: Dp = Dimensions.medium, modifier: Modifier = Modifier) {
    Spacer(modifier.size(size))
}