package com.haitrvn.features.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CommonText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.arg.LoginScreenArgument
import org.koin.compose.koinInject

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinInject<HomeViewModel>(),
    navigator: Navigator,
    arg: LoginScreenArgument?,
) {
    val loginState by viewmodel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 30.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        CommonText(text = "This is home", modifier = modifier.clickable {
            navigator.navigate(Auth.Login())
        })
    }
}