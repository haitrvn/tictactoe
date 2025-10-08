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
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.LargeSpace
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.Title
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.splash.Res
import cookapp.resources.splash.splash_best_recipes
import cookapp.resources.splash.splash_bg
import cookapp.resources.splash.splash_button_start
import cookapp.resources.splash.splash_let_cooking
import cookapp.resources.splash.splash_views
import cookapp.resources.splash.splash_views_recipes

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    SplashScreen(modifier = modifier) { navigator.navigate(Auth.Login) }
}

@Composable
internal fun SplashScreen(modifier: Modifier = Modifier, onStartClick: () -> Unit = {}) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            source = Res.drawable.splash_bg,
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
                    startY = 400f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text.Header(
                modifier = Modifier.fillMaxWidth(),
                text = Res.string.splash_let_cooking.toText(),
                fontSize = 56.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            LargeSpace()
            Text.Paragraph(
                modifier = Modifier.fillMaxWidth(),
                text = Res.string.splash_best_recipes.toText(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
            LargeSpace()
            Button.Curved(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)),
                text = Res.string.splash_button_start.toText(),
                onClick = onStartClick,
            )
            LargeSpace()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text.Title(
                    text = Res.string.splash_views.toText(),
                )
                SmallSpace()
                Text.Paragraph(
                    text = Res.string.splash_views_recipes.toText(),
                )
            }
        }
    }
}