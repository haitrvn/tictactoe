@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.login

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.Card
import com.haitrvn.coreui.CookBigPrimaryButton
import com.haitrvn.coreui.CookBigSecondaryButton
import com.haitrvn.coreui.CookHeaderText
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookParagraphText
import com.haitrvn.coreui.CookTextInput
import com.haitrvn.coreui.CookTitleText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.Navigator

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        // Background image
        CookImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            url = "https://images.unsplash.com/photo-1556909114-f6e7ad7d3136?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1000&q=80"
        )

        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.3f),
                            Color.Black.copy(alpha = 0.7f)
                        )
                    )
                )
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top section with welcome text
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 60.dp)
            ) {
                CookHeaderText(
                    text = "Welcome Back!",
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                CookParagraphText(
                    text = "Sign in to continue your culinary journey",
                    color = Color.White.copy(alpha = 0.8f)
                )
            }

            // Login form card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                color = Color.White.copy(alpha = 0.95f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CookTitleText(
                        text = "Login",
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    // Email input
                    CookTextInput(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Password input
                    CookTextInput(
                        value = password,
                        onValueChange = { password = it },
                        isPassword = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    )

                    // Login button
                    CookBigPrimaryButton(
                        text = "Login",
                        onClick = {
                            navigator.navigate(Home, popUpToRoute = Auth, popUpToInclusive = true)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                    )

                    // Sign up section
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CookParagraphText(
                            text = "Don't have an account?",
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        CookBigSecondaryButton(
                            text = "Sign Up",
                            onClick = {
                                navigator.navigate(Auth.LoginWithEmail)
                            },
                            modifier = Modifier.width(100.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}