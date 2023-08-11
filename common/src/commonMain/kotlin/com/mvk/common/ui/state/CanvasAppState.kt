package com.mvk.common.ui.state

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import kotlinx.coroutines.CoroutineScope

@Composable
expect fun rememberCanvasAppState(): CanvasAppState

@Stable
expect class CanvasAppState {

    val scaffoldState: ScaffoldState
    val coroutineScope: CoroutineScope
    val currentRoute: String?
}