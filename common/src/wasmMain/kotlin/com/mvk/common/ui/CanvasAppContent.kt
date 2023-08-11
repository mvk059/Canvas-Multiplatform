package com.mvk.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mvk.common.navigation.Screens
import com.mvk.common.ui.home.Home
import com.mvk.common.ui.state.CanvasAppState

@Composable
actual fun CanvasAppScaffoldContent(
    innerPaddingModifier: PaddingValues,
    appState: CanvasAppState,
) {
    when (appState.currentRoute) {
        Screens.Home.route -> {
            Home(
                modifier = Modifier.fillMaxSize(),
                onListItemClick = appState::navigateTo
            )
        }

        Screens.StarField.route -> {
            StarField(
                modifier = Modifier.fillMaxSize(),
                onDesktopBackClick = appState::upPress
            )
        }

        else -> {
            Text(
                modifier = Modifier.padding(innerPaddingModifier).fillMaxSize().background(color = Color.Black),
                text = "${appState.currentRoute}"
            )
        }
    }
}