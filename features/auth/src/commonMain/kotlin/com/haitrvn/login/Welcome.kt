package com.haitrvn.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookBigPrimaryButton
import com.haitrvn.coreui.CookHeaderText
import com.haitrvn.coreui.CookParagraphText
import com.haitrvn.coreui.CookLabel1Text
import com.haitrvn.coreui.theme.CookTheme
import androidx.compose.material3.Icon
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import org.jetbrains.compose.resources.vectorResource

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    onStartCookingClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        // Background image with gradient overlay
        CookImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            url = "https://wallpapers.com/images/featured/cute-food-vnp4s9nvgi2bmjnx.jpg"
        )
        
        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.6f),
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        
        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            
            // Premium recipes label with star icon
            Row(
                modifier = Modifier.padding(top = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = vectorResource(Res.drawable.ic_cyclone1),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                CookLabel1Text(
                    text = "60k+",
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(4.dp))
                CookParagraphText(
                    text = "Premium recipes",
                    color = Color.White
                )
            }
            
            // Main content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 80.dp)
            ) {
                CookHeaderText(
                    text = "Let's\nCooking",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
                
                CookParagraphText(
                    text = "Find best recipes for cooking",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 40.dp)
                )
                
                CookBigPrimaryButton(
                    text = "Start cooking",
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onStartCookingClick
                )
            }
            
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
} 