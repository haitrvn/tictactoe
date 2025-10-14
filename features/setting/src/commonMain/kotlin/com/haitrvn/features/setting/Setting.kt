package com.haitrvn.features.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Circle
import com.haitrvn.coreui.CustomSpace
import com.haitrvn.coreui.H5
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Label
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.Primary
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.Text
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
    modifier: Modifier = Modifier,
    uiState: SettingUiState
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
            .padding(top = 24.dp, start = 20.dp, end = 20.dp)
    ) {
        item {
            Profile()
        }
        item {
            FeaturedPhotos()
        }
    }
}

@Composable
fun FeaturedPhotos(modifier: Modifier = Modifier) {

}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image.Circle(modifier = Modifier.size(100.dp), source = "")
            Button.Primary(text = "Edit Profile") {
            }
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
fun VerticalDivider(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxHeight().width(1.dp).background(Color.Green))
}

@Composable
fun Followers(modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
        Column {
            Text.Label(text = "Recipe")
            Text.H5(text = "100")
        }
        VerticalDivider(modifier = Modifier.fillMaxHeight())
        Column {
            Text.Label(text = "Followers")
            Text.H5(text = "100")
        }
        VerticalDivider(modifier = Modifier.fillMaxHeight())
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