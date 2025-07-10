import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.haitrvn.data.di.dataModule
import com.haitrvn.features.home.di.homeModule
import com.haitrvn.features.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import com.haitrvn.tictactoe.App
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(homeModule, loginModule, dataModule, navigationMode)
    }
    Window(
        title = "TicTacToe",
        alwaysOnTop = true,
        state = rememberWindowState(width = 350.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}

