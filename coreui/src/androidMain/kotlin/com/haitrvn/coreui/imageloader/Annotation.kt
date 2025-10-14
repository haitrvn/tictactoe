package com.haitrvn.coreui.imageloader

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Nexus 4 - small", device = "id:Nexus 4", showBackground = false)
@Preview(name = "pixel_9_pro - medium - light", device = "id:pixel_9_pro")
@Preview(
    name = "pixel_9_pro - medium - dark",
    device = "id:pixel_9_pro", showSystemUi = false, showBackground = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Repeatable
annotation class DevicesPreview