package com.haitrvn.features.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Circle
import com.haitrvn.coreui.CustomSpace
import com.haitrvn.coreui.H5
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Label
import com.haitrvn.coreui.LargeSpace
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.Primary
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.theme.Shapes
import com.haitrvn.coreui.theme.Space

@Composable
fun Setting(modifier: Modifier = Modifier) {
    val uiState = SettingUiState(
        userName = "Nguyen Van A",
        aboutMe = "I am a chef",
        recipe = 10,
        followers = 100,
        following = 100,
        featuredPhotos = listOf()
    )
    Setting(modifier = modifier, uiState = uiState)
}

@Composable
fun Setting(
    modifier: Modifier = Modifier, uiState: SettingUiState
) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(top = 24.dp, start = 20.dp, end = 20.dp)
    ) {
        item {
            Profile()
        }
        item {
            LargeSpace()
        }
        item {
            FeaturedPhotos()
        }
    }
}

@Composable
fun FeaturedPhotos(modifier: Modifier = Modifier) {
    val list = (1..10).map { it.toString() }
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(Space.medium),
        horizontalArrangement = Arrangement.spacedBy(Space.medium),
        modifier = Modifier.fillMaxWidth().aspectRatio(1f),
        columns = GridCells.Fixed(2),
        content = {
            items(list.size) { index ->
                Image(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f).clip(Shapes.rounded),
                    source = "https://picsum.photos/200/300"
                )
            }
        }
    )
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image.Circle(
                modifier = Modifier.size(100.dp),
                source = "https://img.freepik.com/free-psd/3d-illustration-human-avatar-profile_23-2150671142.jpg?semt=ais_hybrid&w=740&q=80"
            )
            Button.Primary(text = "Edit Profile") {}
        }
        MediumSpace()
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text.H5(text = "Robert hurtson")
            SmallSpace()
            Text.Label(text = "Hello world I’m lorenz florenza,\nI’m from Indonesia.")
            CustomSpace(Space.medium + Space.tiny)
            Followers()
        }
    }
}

@Composable
fun Followers(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.wrapContentWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text.Label(text = "Recipe")
            Text.H5(text = "100")
        }
        Box(modifier = Modifier.fillMaxHeight().width(1.dp).background(Color.Red))
        Column {
            Text.Label(text = "Followers")
            Text.H5(text = "100")
        }
        Box(modifier = Modifier.fillMaxHeight().width(1.dp).background(Color.Red))
        Column {
            Text.Label(text = "Following")
            Text.H5(text = "100")
        }
    }
}

data class SettingUiState(
    val userName: String,
    val aboutMe: String,
    val recipe: Int,
    val followers: Int,
    val following: Int,
    val featuredPhotos: List<String>,
)