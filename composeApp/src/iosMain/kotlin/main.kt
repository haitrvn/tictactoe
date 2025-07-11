import androidx.compose.ui.window.ComposeUIViewController
import com.haitrvn.cookapp.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
