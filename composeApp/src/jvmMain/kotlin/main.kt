import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.haitrvn.data.di.dataModule
import com.haitrvn.features.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import com.haitrvn.tictactoe.App
import org.koin.core.context.startKoin
import java.awt.Color
import java.awt.Dimension

fun main() = application {
    startKoin {
        modules(loginModule, dataModule, navigationMode)
    }
    Window(
        title = "TicTacToe",
        alwaysOnTop = true,
        state = rememberWindowState(width = 350.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.background = Color.WHITE
        window.minimumSize = Dimension(350, 600)
        App()
    }
}

