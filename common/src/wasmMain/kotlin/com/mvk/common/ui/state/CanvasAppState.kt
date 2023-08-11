package com.mvk.common.ui.state

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.mvk.common.navigation.NavigationStack
import com.mvk.common.navigation.Screens
import kotlinx.coroutines.CoroutineScope

@Composable
actual fun rememberCanvasAppState(): CanvasAppState {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    return remember(scaffoldState, coroutineScope) {
        CanvasAppState(scaffoldState, coroutineScope)
    }
}

@Stable
actual class CanvasAppState(
    actual val scaffoldState: ScaffoldState,
    actual val coroutineScope: CoroutineScope,
) {

    private val navigationStack = NavigationStack(Screens.StarField.route)

    actual val currentRoute: String?
        get() = navigationStack.lastWithIndex().value

    fun upPress() {
        navigationStack.back()
    }

    fun navigateTo(screenId: Screens) {
        navigationStack.push("$screenId")
    }
}