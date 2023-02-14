package com.mvk.android.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mvk.common.App
import com.mvk.common.Canvas
import com.mvk.common.navigation.Screens
import com.mvk.common.ui.StarField

@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screens.Home.route,
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        builder = {

            composable(
                route = Screens.Home.route,
                content = {
                    App(onListItemClick = { navController.navigate(it.route) })
                }
            )

            composable(
                route = Screens.Basics.route,
                content = {
                    Canvas(
                        modifier = Modifier.fillMaxSize(),
                        onDesktopBackClick = { navController.popBackStack() })
                }
            )

            composable(Screens.StarField.name) {
                StarField(
                    modifier = Modifier.fillMaxSize(),
                    onDesktopBackClick = { navController.popBackStack() }
                )
            }
        }
    )
}
