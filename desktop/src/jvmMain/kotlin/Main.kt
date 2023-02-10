import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mvk.common.App
import com.mvk.common.navigation.Screens
import navigation.Navigation
import navigation.rememberNavController

fun main() = application {

    Window(
        title = "Compose Canvas Desktop",
        onCloseRequest = ::exitApplication,
        content = {

            val navController by rememberNavController(Screens.Home.name)
            val currentScreen by remember { navController.currentScreen }

            App(
                onListItemClick = { navController.navigate(it.route) }
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                content = { Navigation(navController = navController) }
            )
        }
    )
}
