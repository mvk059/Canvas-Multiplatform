import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.mvk.common.ui.CanvasApp
import com.mvk.common.ui.StarField
import com.mvk.common.ui.components.prepareImagesCache
import util.loadKarlaFont
import util.loadMontserratFont

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow("Chip8", canvasElementId = "jetsnackCanvas") {

        var loading: Boolean by remember { mutableStateOf(true) }

        if (loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else {
            CanvasApp()
        }

        LaunchedEffect(Unit) {
            loadMontserratFont()
            loadKarlaFont()
            prepareImagesCache()
            loading = false
        }
    }
}
