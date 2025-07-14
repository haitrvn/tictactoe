package com.haitrvn.features.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CookBodyText
import com.haitrvn.navigation.NavigationItem
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onItemClick: (NavigationItem) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            NavigationBarItem(
                selected = currentRoute == navigationItem.destination::class.qualifiedName,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        imageVector = vectorResource(navigationItem.unSelectedIcon),
                        contentDescription = stringResource(navigationItem.title),
                    )
                },
                label = {
                    CookBodyText(
                        text = stringResource(navigationItem.title),
                    )
                },
            )
        }
    }
}