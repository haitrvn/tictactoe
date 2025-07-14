package com.haitrvn.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.CookBodyText
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.home.Res
import cookapp.resources.home.card_image_1
import cookapp.resources.home.play_icon
import cookapp.resources.home.star_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiscoverScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CookTheme.colors.background),
    ) {
        item {
            StatusBar(modifier = modifier)
            Heading()
            Tabs()
            CardsSection()
            Spacer(modifier = Modifier)
            BottomNavigationBar()
            HomeIndicator()
        }
    }
}

@Composable
fun StatusBar(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier)
}

@Composable
fun Heading(modifier: Modifier = Modifier) {
    CookSurface(
        modifier = modifier
            .fillMaxWidth()
    ) {
        CookBodyText(
            text = "Saved recipes",
        )
    }
}

@Composable
fun Tabs(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CookSurface(
            modifier = Modifier
                .background(CookTheme.colors.background, RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Video",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = CookTheme.colors.textPrimary,
                textAlign = TextAlign.Center
            )
        }
        CookSurface(
            modifier = Modifier
                .background(CookTheme.colors.background, RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Recipes",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = CookTheme.colors.textPrimary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CardsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        DiscoverCard(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
        DiscoverCard(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
        DiscoverCard(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp))
    }
}

@Composable
fun DiscoverCard(modifier: Modifier = Modifier) {
    CookSurface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CookTheme.colors.background)
            .shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            CookSurface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(Res.drawable.card_image_1),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                CookSurface(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clip(CircleShape)
                        .background(CookTheme.colors.textPrimary)
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.play_icon),
                        contentDescription = null,
                    )
                }
                CookSurface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(CookTheme.colors.textPrimary)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.star_icon),
                            contentDescription = null,
                            modifier = Modifier
                        )
                        Text(
                            text = "4,7",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = CookTheme.colors.textPrimary,
                            modifier = Modifier.padding(start = 3.dp)
                        )
                    }
                }
                CookSurface(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(CookTheme.colors.textPrimary)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "8:12",
                        fontSize = 12.sp,
                        color = CookTheme.colors.textPrimary
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "How to make sandwich",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = CookTheme.colors.textPrimary,
                modifier = Modifier.padding(start = 0.dp, top = 0.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                CookSurface(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(CookTheme.colors.textPrimary)
                        .padding(12.dp)
                ) {
                    // Avatar image placeholder
                }
                Text(
                    text = "By Robert hurtson",
                    fontSize = 12.sp,
                    color = CookTheme.colors.textPrimary,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    // Placeholder for bottom navigation bar
    Spacer(modifier = modifier)
}

@Composable
fun HomeIndicator(modifier: Modifier = Modifier) {
    // Placeholder for home indicator
    Spacer(modifier = modifier)
} 