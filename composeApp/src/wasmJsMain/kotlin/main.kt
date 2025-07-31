import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.haitrvn.cookapp.App
import com.haitrvn.cookapp.appModule
import kotlinx.browser.document
import org.koin.core.context.startKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    startKoin {
        modules(appModule)
    }
    val body = document.body ?: return
    ComposeViewport(body) {
        App()
    }
}
