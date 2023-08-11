package com.mvk.common.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mvk.common.ui.state.rememberCanvasAppState
import com.mvk.common.ui.theme.CanvasTheme

@Composable
fun CanvasApp() {

    val state = rememberCanvasAppState()

    CanvasTheme {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = state.scaffoldState,
            content = {
                CanvasAppScaffoldContent(innerPaddingModifier = it, appState = state)
            }
        )
    }
}
