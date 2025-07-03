package com.haitrvn.features.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import cookapp.features.home.generated.resources.Res
import cookapp.features.home.generated.resources.card_image_1
import cookapp.features.home.generated.resources.play_icon
import cookapp.features.home.generated.resources.star_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun DiscoverScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        item {
            StatusBar()
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
fun StatusBar() {
    // Placeholder for status bar
    Spacer(modifier = Modifier.height(44.dp))
}

@Composable
fun Heading(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(69.dp)
            .padding(top = 44.dp)
    ) {
        CommonText(
            text = "Saved recipes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 22.dp, top = 20.dp)
        )
    }
}

@Composable
fun Tabs() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
            .padding(horizontal = 20.dp, vertical = 12.dp),
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
fun CardsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        DiscoverCard()
        DiscoverCard()
        DiscoverCard()
    }
}

@Composable
fun DiscoverCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .height(246.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .shadow(2.dp, RoundedCornerShape(16.dp))
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Image(
                    painter = painterResource(Res.drawable.card_image_1),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color(0x636B6B6B))
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
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF797979))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(Res.drawable.star_icon),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
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
                        .padding(8.dp)
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
            Spacer(modifier = Modifier.height(8.dp))
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
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFC4C4C4))
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
fun BottomNavigationBar() {
    // Placeholder for bottom navigation bar
    Spacer(modifier = Modifier.height(122.dp))
}

@Composable
fun HomeIndicator() {
    // Placeholder for home indicator
    Spacer(modifier = Modifier.height(34.dp))
} 