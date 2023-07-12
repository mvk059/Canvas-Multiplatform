package com.mvk.common.ui

import androidx.compose.foundation.Canvas
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.mvk.common.ui.components.AppBar

/**
 * Canvas Basics
 */
@Composable
fun Canvas(
    modifier: Modifier = Modifier,
    onDesktopBackClick: () -> Unit,
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            AppBar(
                title = "Basics",
                onNavigationIconClick = { onDesktopBackClick() }
            )
        },
        content = {
            Canvas(
                modifier = modifier
            ) {
                drawRect(
                    color = Color.Black,
                    size = size
                )
                drawRect(
                    color = Color.Red,
                    topLeft = Offset(100f, 100f),
                    style = Stroke(
                        width = 3.dp.toPx()
                    ),
                    size = Size(100f, 100f)
                )
                drawCircle(
                    radius = 100f,
                    center = center,
                    brush = Brush.radialGradient(
                        colors = listOf(Color.Red, Color.Cyan),
                        center = center,
                        radius = 100f
                    )
                )
                drawArc(
                    color = Color.Green,
                    startAngle = 0f,
                    sweepAngle = 270f,
                    useCenter = true,
                    topLeft = Offset(100f, 500f),
                    size = Size(100f, 100f),
                    style = Stroke(
                        width = 3.dp.toPx()
                    )
                )
                drawOval(
                    color = Color.Magenta,
                    topLeft = Offset(600f, 100f),
                    size = Size(100f, 200f)
                )
                drawLine(
                    color = Color.Cyan,
                    start = Offset(100f, 300f),
                    end = Offset(300f, 300f),
                    strokeWidth = 5.dp.toPx()
                )
            }
        }
    )
}

