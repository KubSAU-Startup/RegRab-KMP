import androidx.compose.ui.window.ComposeUIViewController
import com.kubsau.regrab.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
