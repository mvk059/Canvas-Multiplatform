package com.mvk.common.ui.state

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import kotlinx.coroutines.CoroutineScope

@Composable
actual fun rememberCanvasAppState(): CanvasAppState {
    TODO("Not yet implemented")
}

@Stable
actual class CanvasAppState {
    actual val scaffoldState: ScaffoldState
        get() = TODO("Not yet implemented")
    actual val coroutineScope: CoroutineScope
        get() = TODO("Not yet implemented")
    actual val currentRoute: String?
        get() = TODO("Not yet implemented")

}