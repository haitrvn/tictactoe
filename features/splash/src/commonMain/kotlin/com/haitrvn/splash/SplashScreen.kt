package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.LargeSpace
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.Title
import com.haitrvn.coreui.theme.Colors
import cookapp.resources.splash.Res
import cookapp.resources.splash.splash_bg

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onStartClick: () -> Unit = {}) {
    Box(modifier = modifier.fillMaxSize()) {
        // Background image
        CookImage(
            modifier = Modifier.fillMaxSize(),
            source = Res.drawable.splash_bg,
            contentScale = ContentScale.Crop
        )
        // Gradient overlay (bottom)
        Box(
            Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                    startY = 400f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
        )
        // Content
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title
            Text.Header(
                text = "Let’s\nCooking",
                color = Color.White,
                fontSize = 56.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            LargeSpace()
            // Subtitle
            Text.Paragraph(
                text = "Find best recipes for cooking",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            LargeSpace()
            // Button
            Button.Curved(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)),
                onClick = onStartClick,
                backgroundColor = Colors.primary
            ) {
                Row(
                    Modifier.padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text.Title(
                        text = "Start cooking",
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    // TODO: Add Arrow-Right icon if available
                }
            }
            LargeSpace()
            // Label (60k+ Premium recipes)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // TODO: Add Star icon if available
                Text.Title(
                    text = "60k+",
                    color = Color.White,
                )
                SmallSpace()
                Text.Paragraph(
                    text = "Premium recipes", color = Color.White
                )
            }
        }
    }
}