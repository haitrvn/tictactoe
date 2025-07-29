package com.haitrvn.features.setting

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookPrimaryButton
import com.haitrvn.coreui.utils.clickableSingle

@Composable
private fun Avatar(
    userName: String,
    userEmail: String,
    onEditAvatar: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        CookImage(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape),
            url = ""
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            TextParagraph(text = userName)
            TextParagraph(text = userEmail)
        }
        CookPrimaryButton(
            modifier = Modifier,
            text = "Edit",
            onClick = onEditAvatar
        )
    }
}

@Composable
private fun SettingsList(
    generalSettings: List<String>,
    securitySettings: List<String>,
    onSettingClick: (String) -> Unit,
    onLogout: () -> Unit
) {
    LazyColumn(modifier = Modifier) {
        item {
            TextParagraph(
                text = "General",
                modifier = Modifier.padding(vertical = 8.dp),
            )
        }
        items(generalSettings) { title ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableSingle { onSettingClick(title) }
                    .padding(vertical = 12.dp)
            ) {
                TextParagraph(text = title)
            }
        }
        item {
            TextParagraph(
                text = "Security",
                modifier = Modifier.padding(vertical = 8.dp),
            )
        }
        items(securitySettings) { title ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickableSingle { onSettingClick(title) }
                    .padding(vertical = 12.dp)
            ) {
                TextParagraph(text = title)
            }
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            CookPrimaryButton(
                text = "Log Out",
                onClick = onLogout
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun Privacy(
    appVersion: String,
    onTermsClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextParagraph(
            text = "App Version $appVersion",
        )
        Spacer(modifier = Modifier.height(4.dp))
        TextParagraph(
            text = "Terms of Service",
            modifier = Modifier.clickableSingle(onClick = onTermsClick),
        )
    }
}

@Composable
fun Setting(
    userName: String = "User Name",
    userEmail: String = "user@example.com",
    generalSettings: List<String> = listOf("Notifications", "Privacy"),
    securitySettings: List<String> = listOf("Change Password", "Two-Factor Authentication"),
    onEditAvatar: () -> Unit = {},
    onSettingClick: (String) -> Unit = {},
    onLogout: () -> Unit = {},
    appVersion: String = "1.0.0",
    onTermsClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Avatar(userName, userEmail, onEditAvatar)
        Spacer(modifier = Modifier.height(24.dp))
        Box(modifier = Modifier.weight(1f)) {
            SettingsList(generalSettings, securitySettings, onSettingClick, onLogout)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Privacy(appVersion, onTermsClick)
    }
}