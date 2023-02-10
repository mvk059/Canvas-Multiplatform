package navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mvk.common.App
import com.mvk.common.Canvas
import com.mvk.common.navigation.Screens

@Composable
fun Navigation(
    navController: NavController
) {
    NavigationHost(
        navController,
        content = {

            composable(Screens.Home.name) {
                App(
                    onListItemClick = {
                        navController.navigate(it.name)
                    }
                )
            }

            composable(Screens.Basics.name) {
                Canvas(
                    modifier = Modifier.fillMaxSize(),
                    onDesktopBackClick = {
                        navController.navigateBack()
                    }
                )
            }
        }
    ).build()
}