import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.haitrvn.auth.di.loginModule
import com.haitrvn.cookapp.App
import com.haitrvn.data.di.dataModule
import com.haitrvn.home.di.homeModule
import com.haitrvn.navigation.di.navigationMode
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController

fun MainViewController(
    topPadding: Float,
    bottomPadding: Float,
    startPadding: Float,
    endPadding: Float
): UIViewController = ComposeUIViewController {
    App(
        modifier = Modifier
            .padding(
                top = topPadding.dp,
                bottom = bottomPadding.dp,
                start = startPadding.dp,
                end = endPadding.dp
            )
            .background(Color.Black)
    )
}

fun initInjection() {
    startKoin {
        modules(homeModule, loginModule, dataModule, navigationMode)
    }
}
