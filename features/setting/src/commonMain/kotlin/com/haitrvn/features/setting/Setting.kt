package com.haitrvn.features.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haitrvn.coreui.component.Button
import com.haitrvn.coreui.component.Circle
import com.haitrvn.coreui.component.CustomSpace
import com.haitrvn.coreui.component.H5
import com.haitrvn.coreui.component.Image
import com.haitrvn.coreui.component.Label
import com.haitrvn.coreui.component.LargeSpace
import com.haitrvn.coreui.component.MediumSpace
import com.haitrvn.coreui.component.Normal
import com.haitrvn.coreui.component.Primary
import com.haitrvn.coreui.component.SmallSpace
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.theme.Shapes
import com.haitrvn.coreui.utils.toText
import cookapp.resources.setting.Res
import cookapp.resources.setting.ic_cyclone1
import cookapp.resources.setting.setting_edit_profile
import cookapp.resources.setting.setting_followers
import cookapp.resources.setting.setting_following
import cookapp.resources.setting.setting_recipe
import cookapp.resources.setting.setting_video
import org.koin.compose.koinInject

@Composable
fun Setting(
    modifier: Modifier = Modifier,
) {
    val viewmodel: SettingViewModel = koinInject()
    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()
    Setting(modifier = modifier, uiState = uiState)
}

@Composable
fun Setting(
    modifier: Modifier = Modifier, uiState: SettingUiState
) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()),
    ) {
        CustomSpace(Dimensions.extraLarge)
        Profile(
            modifier = Modifier.padding(horizontal = 20.dp),
            avatarUrl = uiState.userAvatar,
            userName = uiState.userName,
            aboutMe = uiState.aboutMe,
            recipe = uiState.recipe,
            followers = uiState.followers,
            following = uiState.following
        )
        LargeSpace()
        if (uiState.featuredPhotos.isNotEmpty()) {
            FeaturedPhotos(modifier = Modifier, uiState.featuredPhotos.toMutableStateList())
            LargeSpace()
        }
        SettingItems(modifier = Modifier.padding(horizontal = 20.dp))
        LargeSpace()
    }
}

@Composable
private fun SettingItems(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(Dimensions.medium)
    ) {
        SettingItem(label = Res.string.setting_following.toText()) {}
        SettingItem(label = Res.string.setting_following.toText()) {}
        SettingItem(label = Res.string.setting_following.toText()) {}
    }
}

@Composable
private fun SettingItem(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
) {
    Row(modifier = modifier.fillMaxWidth().background(Color.Red).clickable { onClick }
        .padding(Dimensions.medium), horizontalArrangement = Arrangement.SpaceBetween) {
        Text.Label(text = label)
        Image.Normal(modifier = Modifier.background(Color.White), source = Res.drawable.ic_cyclone1)
    }
}

@Composable
fun Profile(
    modifier: Modifier = Modifier,
    avatarUrl: String = "",
    userName: String = "",
    aboutMe: String = "",
    recipe: Int = 0,
    followers: Int = 0,
    following: Int = 0,
) {
    Column(
        modifier = modifier, horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image.Circle(
                modifier = Modifier.size(120.dp).border(2.dp, AppColors.primary, Shapes.circle),
                source = avatarUrl
            )
            Button.Primary(text = Res.string.setting_edit_profile.toText()) {}
        }
        MediumSpace()
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
            Text.H5(text = userName)
            SmallSpace()
            Text.Label(text = aboutMe)
            CustomSpace(Dimensions.medium + Dimensions.tiny)
            Followers(
                modifier = Modifier,
                recipe = recipe,
                followers = followers,
                following = following,
            )
        }
    }
}

@Composable
fun Followers(
    modifier: Modifier = Modifier,
    recipe: Int = 0,
    video: Int = 0,
    followers: Int = 0,
    following: Int = 0,
) {
    Row(
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text.Label(text = Res.string.setting_recipe.toText())
            Text.H5(text = recipe.toString())
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text.Label(text = Res.string.setting_video.toText())
            Text.H5(text = video.toString())
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text.Label(text = Res.string.setting_followers.toText())
            Text.H5(text = followers.toString())
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text.Label(text = Res.string.setting_following.toText())
            Text.H5(text = following.toString())
        }
    }
}

@Composable
fun FeaturedPhotos(
    modifier: Modifier = Modifier,
    featuredPhotos: SnapshotStateList<String> = mutableStateListOf(),
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth().aspectRatio(1f).background(AppColors.surface)
            .padding(Dimensions.medium),
        verticalArrangement = Arrangement.spacedBy(Dimensions.medium),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.medium),
        columns = GridCells.Fixed(2),
        content = {
            items(featuredPhotos.size) { index ->
                Image.Normal(
                    modifier = Modifier.fillMaxWidth().aspectRatio(1f).clip(Shapes.rounded),
                    source = featuredPhotos[index]
                )
            }
        })
}