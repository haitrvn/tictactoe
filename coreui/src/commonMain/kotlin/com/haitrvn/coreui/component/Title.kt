package com.haitrvn.coreui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.utils.toText
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_see_all
import cookapp.resources.core.ui.icon_arrow_see_all

@Composable
fun Title(
    modifier: Modifier = Modifier,
    title: String,
    seeAllClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text.H5(text = title)
        Row(modifier = Modifier.clickable { seeAllClick() }) {
            Text.LabelBold(text = Res.string.core_ui_see_all.toText(), color = AppColors.primary)
            TinySpace()
            Image.Normal(source = Res.drawable.icon_arrow_see_all)
        }
    }
}