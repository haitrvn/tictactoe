package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable


@Composable
@Preview
fun PreviewHeader() {
    Column {
        Header(title = "Sample header")
        Header(title = "Sample header", isBackable = true)
    }
}