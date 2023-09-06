import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.mvk.common.ui.StarField

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow("Chip8", canvasElementId = "jetsnackCanvas") {
        StarField()
    }
}
