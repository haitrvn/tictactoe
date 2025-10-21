package com.haitrvn.coreui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.theme.Dimensions
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_icon_back
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    isBackable: Boolean = false,
    icon: DrawableResource? = null,
    back: () -> Unit = {},
    headerAction: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(Dimensions.medium)
    ) {
        if (isBackable) {
            Image.Normal(
                modifier = Modifier.size(Dimensions.iconSize).clickable { back() },
                source = Res.drawable.core_ui_icon_back
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text.H4(text = title)
            icon?.let {
                Image.Normal(
                    modifier = Modifier.size(Dimensions.iconSize).clickable { headerAction() },
                    source = it
                )
            }
        }
    }
}