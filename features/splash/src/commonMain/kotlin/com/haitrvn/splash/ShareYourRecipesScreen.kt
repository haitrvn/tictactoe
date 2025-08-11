package com.haitrvn.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.ImageRecipe

@Composable
fun SharedYourRecipesScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        ImageRecipe(modifier = Modifier.fillMaxSize(), source = "https://picsum.photos/200/300")
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Transparent)
        )
    }
}