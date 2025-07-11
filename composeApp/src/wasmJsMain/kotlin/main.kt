import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.window.ComposeViewport
import com.haitrvn.cookapp.App
import com.haitrvn.data.di.dataModule
import com.haitrvn.features.home.di.homeModule
import com.haitrvn.features.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import kotlinx.browser.document
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(homeModule, loginModule, dataModule, navigationMode)
    }
    val body = document.body ?: return
    ComposeViewport(body) {
        App()
    }
}
