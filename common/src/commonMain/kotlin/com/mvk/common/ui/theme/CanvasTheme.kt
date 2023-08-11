package com.mvk.common.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

@Composable
internal fun CanvasTheme(
    colors: Colors = LightColorPalette,
    typography: Typography = Typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit,
) {

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content,
    )
}
