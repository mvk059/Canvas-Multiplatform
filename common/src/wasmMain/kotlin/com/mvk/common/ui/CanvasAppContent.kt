package com.mvk.common.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mvk.common.ui.state.CanvasAppState

@Composable
actual fun CanvasAppScaffoldContent(
    innerPaddingModifier: PaddingValues,
    appState: CanvasAppState,
) {
    StarField(
        modifier = Modifier.fillMaxSize(),
    )
}