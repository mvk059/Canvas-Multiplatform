package navigation

import androidx.compose.runtime.Composable

/**
 * Custom NavigationHost class based on this <a href="https://github.com/itheamc/navigation-for-compose-for-desktop">link</a>
 */
class NavigationHost(
    val navController: NavController,
    val content: @Composable NavigationGraphBuilder.() -> Unit
) {

    @Composable
    fun build() {
        NavigationGraphBuilder().renderContents()
    }

    inner class NavigationGraphBuilder(
        val navController: NavController = this@NavigationHost.navController
    ) {
        @Composable
        fun renderContents() {
            this@NavigationHost.content(this)
        }
    }
}

/**
 * Composable to build the Navigation Host
 */
@Composable
fun NavigationHost.NavigationGraphBuilder.composable(
    route: String,
    content: @Composable () -> Unit
) {
    if (navController.currentScreen.value == route) {
        content()
    }
}