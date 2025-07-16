import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.ComposeUIViewController
import com.haitrvn.cookapp.App
import com.haitrvn.data.di.dataModule
import com.haitrvn.home.di.homeModule
import com.haitrvn.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    App(modifier = Modifier.background(Color.Black).windowInsetsPadding(WindowInsets.safeDrawing))
}

fun initInjection() {
    startKoin {
        modules(homeModule, loginModule, dataModule, navigationMode)
    }
}
