package com.haitrvn.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.CommonText
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
            .background(Color.White),
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
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        CommonText(
            text = "Saved recipes",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
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
        Box(
            modifier = Modifier
                .background(Color(0xFF797979), RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Video",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .background(Color(0xFF898989), RoundedCornerShape(10.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Recipes",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC1C1C1),
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
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Column(modifier = Modifier.padding(0.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(Res.drawable.card_image_1),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .clip(CircleShape)
                        .background(Color(0x636B6B6B))
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.play_icon),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF797979))
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
                            color = Color.White,
                            modifier = Modifier.padding(start = 3.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF797979))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "8:12",
                        fontSize = 12.sp,
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "How to make sandwich",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF181818),
                modifier = Modifier.padding(start = 0.dp, top = 0.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color(0xFFC4C4C4))
                        .padding(12.dp)
                ) {
                    // Avatar image placeholder
                }
                Text(
                    text = "By Robert hurtson",
                    fontSize = 12.sp,
                    color = Color(0xFF797979),
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