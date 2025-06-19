package com.haitrvn.tictactoe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.haitrvn.navigation.GraphDestination
import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.loginScreen
import com.haitrvn.tictactoe.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.ParametersHolder

@Preview
@Composable
internal fun App() = AppTheme {
    val navController = rememberNavController()
    val navigator: Navigator = koinInject<Navigator>(parameters = {
        ParametersHolder(
            mutableListOf(
                navController
            )
        )
    })
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = GraphDestination.Login
    ) {
        loginScreen(navigator)
    }

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .windowInsetsPadding(WindowInsets.safeDrawing)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = stringResource(Res.string.cyclone),
//            fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
//            style = MaterialTheme.typography.displayLarge
//        )
//
//        var isRotating by remember { mutableStateOf(false) }
//
//        val rotate = remember { Animatable(0f) }
//        val target = 360f
//        if (isRotating) {
//            LaunchedEffect(Unit) {
//                while (isActive) {
//                    val remaining = (target - rotate.value) / target
//                    rotate.animateTo(target, animationSpec = tween((1_000 * remaining).toInt(), easing = LinearEasing))
//                    rotate.snapTo(0f)
//                }
//            }
//        }
//
//        Image(
//            modifier = Modifier
//                .size(250.dp)
//                .padding(16.dp)
//                .run { rotate(rotate.value) },
//            imageVector = vectorResource(Res.drawable.ic_cyclone),
//            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
//            contentDescription = null
//        )
//
//        ElevatedButton(
//            modifier = Modifier
//                .padding(horizontal = 8.dp, vertical = 4.dp)
//                .widthIn(min = 200.dp),
//            onClick = { isRotating = !isRotating },
//            content = {
//                Icon(vectorResource(Res.drawable.ic_rotate_right), contentDescription = null)
//                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
//                Text(
//                    stringResource(if (isRotating) Res.string.stop else Res.string.run)
//                )
//            }
//        )
//
//        var isDark by LocalThemeIsDark.current
//        val icon = remember(isDark) {
//            if (isDark) Res.drawable.ic_light_mode
//            else Res.drawable.ic_dark_mode
//        }
//
//        ElevatedButton(
//            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
//            onClick = { isDark = !isDark },
//            content = {
//                Icon(vectorResource(icon), contentDescription = null)
//                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
//                Text(stringResource(Res.string.theme))
//            }
//        )
//
//        val uriHandler = LocalUriHandler.current
//        TextButton(
//            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).widthIn(min = 200.dp),
//            onClick = { uriHandler.openUri("https://github.com/terrakok") },
//        ) {
//            Text(stringResource(Res.string.open_github))
//        }
//    }
}
