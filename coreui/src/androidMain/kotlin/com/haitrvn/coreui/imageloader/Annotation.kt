package com.haitrvn.coreui.imageloader

import androidx.compose.ui.tooling.preview.Preview
import android.content.res.Configuration

@Preview(device = "id:Nexus 4", showBackground = false)
@Preview(device = "id:pixel_9_pro")
@Preview(
    device = "id:pixel_9_pro", showSystemUi = false, showBackground = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Repeatable
annotation class DevicesPreview