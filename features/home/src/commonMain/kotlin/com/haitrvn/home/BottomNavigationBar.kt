package com.haitrvn.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: Screen?,
    onItemClick: (NavigationItem) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp) // Default height for NavigationBar
            .background(Color.White), // Use your theme's surface color
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { navigationItem ->
            CustomNavigationBarItem(
                navigationItem = navigationItem,
                isSelected = currentRoute == navigationItem.destination,
                onClick = {
                    onItemClick(navigationItem)
                }
            )
        }
    }
}

/**
 * A custom implementation of Material's NavigationBarItem.
 * It uses a Column to arrange an Image and a Text vertically.
 */
@Composable
private fun RowScope.CustomNavigationBarItem(
    navigationItem: NavigationItem,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val iconRes = if (isSelected) {
        navigationItem.selectedIcon
    } else {
        navigationItem.unSelectedIcon
    }
    val textColor = if (isSelected) Color.Blue else Color.Gray // Replace with your theme colors

    Box(
        modifier = Modifier
            .weight(1f) // Each item takes equal space
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null, // No ripple effect
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Image(
                source = vectorResource(iconRes),
                modifier = Modifier.size(24.dp) // Default icon size
            )
            Text.Paragraph(text = navigationItem.title.toText(), color = textColor)
        }
    }
}