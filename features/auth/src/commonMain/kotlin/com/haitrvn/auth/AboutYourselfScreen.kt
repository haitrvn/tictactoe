package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import com.haitrvn.coreui.component.OnBackgroundText
import com.haitrvn.coreui.component.OnPrimaryText
import com.haitrvn.coreui.component.OnSurfaceText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.AppButton
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

@Composable
fun AboutYourselfScreen(
    onFinishClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedGender by remember { mutableStateOf("Men") }
    var selectedAgeRange by remember { mutableStateOf("Age Range") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        OnBackgroundText(
            text = "Tell us About yourself",
            style = Typography.text2ExtraLargeBold
        )
        Spacer(modifier = Modifier.height(32.dp))
        OnBackgroundText(
            text = "Who do you shop for?",
            style = Typography.textMediumSmallMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GenderButton(
                text = "Men",
                isSelected = selectedGender == "Men",
                onClick = { selectedGender = "Men" },
                modifier = Modifier.weight(1f)
            )
            GenderButton(
                text = "Women",
                isSelected = selectedGender == "Women",
                onClick = { selectedGender = "Women" },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        OnBackgroundText(
            text = "How Old are you?",
            style = Typography.textMediumSmallMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(AppColors.surface)
                .clickable { /* Show age picker */ }
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            OnSurfaceText(
                text = selectedAgeRange,
                style = Typography.textMediumSmallMedium
            )
            // TODO: Add dropdown icon
        }
        Spacer(modifier = Modifier.weight(1f))
        AppButton(
            text = "Finish",
            onClick = { onFinishClick() }
        )
    }
}

@Composable
fun GenderButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(if (isSelected) AppColors.primary else AppColors.surface)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isSelected) {
            OnPrimaryText(
                text = text,
                style = Typography.textMediumSmallMedium
            )
        } else {
            OnSurfaceText(
                text = text,
                style = Typography.textMediumSmallMedium
            )
        }
    }
}
