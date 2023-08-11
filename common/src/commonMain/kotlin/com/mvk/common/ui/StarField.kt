package com.mvk.common.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.Constraints
import com.mvk.common.ui.Star.Companion.createStars
import com.mvk.common.utils.lerp
import com.mvk.common.utils.pxToDp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlin.random.Random
import kotlin.time.Duration.Companion.milliseconds

data class Star(
    val x: Float,
    val y: Float,
    val z: Float,
    var pz: Float,
) {

    companion object {

        /**
         * Create a [Star] object
         */
        private fun createStar(constraints: Constraints): Star {
            val cz = Random.nextInt(constraints.maxWidth).toFloat()
            return Star(
                x = Random.nextInt(-constraints.maxWidth, constraints.maxWidth).toFloat(),
                y = Random.nextInt(-constraints.maxHeight, constraints.maxHeight).toFloat(),
                z = cz,
                pz = cz,
            )
        }

        fun createStars(count: Int, constraints: Constraints): List<Star> {
            return buildList {
                repeat(
                    times = count,
                    action = { add(createStar(constraints = constraints)) }
                )
            }
        }
    }

    fun update(speed: Float, constraints: Constraints): Star {

        val updatedZ = z - speed

        if (updatedZ < 1) {
            return this.copy(
                x = Random.nextInt(-constraints.maxWidth, constraints.maxWidth).toFloat(),
                y = Random.nextInt(-constraints.maxHeight, constraints.maxHeight).toFloat(),
                z = constraints.maxWidth.toFloat(),
                pz = constraints.maxWidth.toFloat(),
            )
        }
        return this.copy(
            z = updatedZ,
        )
    }

    fun show(scope: DrawScope, constraints: Constraints, index: Int) {

        scope.apply {

            val sx = lerp(
                from = 0f..1f,
                to = 0f..constraints.maxWidth.toFloat(),
                value = x / z
            )

            val sy = lerp(
                from = 0f..1f,
                to = 0f..constraints.maxHeight.toFloat(),
                value = y / z
            )

            val r = lerp(
                from = 0f..constraints.maxWidth.toFloat(),
                to = 16f..0f,
                value = z
            )

            drawCircle(
                color = Color.White,
                radius = r,
                center = Offset(x = sx, y = sy)
            )

            val px = lerp(
                from = 0f..1f,
                to = 0f..constraints.maxWidth.toFloat(),
                value = x / pz
            )

            val py = lerp(
                from = 0f..1f,
                to = 0f..constraints.maxHeight.toFloat(),
                value = y / pz
            )

            pz = z

            drawLine(
                color = Color.LightGray,
                start = Offset(x = sx, y = sy),
                end = Offset(x = px, y = py),
                strokeWidth = 2f,
            )
        }
    }
}

@Composable
fun StarField(
    modifier: Modifier = Modifier,
    onDesktopBackClick: () -> Unit = {},
) {

    BoxWithConstraints(
        modifier = modifier.fillMaxSize(),
        content = {

            val stars = remember { mutableStateOf(createStars(500, constraints)) }
            val speed = remember { mutableStateOf(50f) }
            val pause = remember { mutableStateOf(false) }

            LaunchedEffect(
                key1 = true,
                key2 = pause.value,
                block = {
                    while (this.isActive && !pause.value) {
                        delay(16.milliseconds)
                        stars.value = stars.value.map {
                            it.update(
                                speed = speed.value,
                                constraints = constraints
                            )
                        }
                    }
                }
            )

            Canvas(
                modifier = Modifier
                    .size(
                        width = constraints.maxWidth.pxToDp(),
                        height = constraints.maxHeight.pxToDp()
                    )
                    .background(color = Color.Black)
                    .clickable { onDesktopBackClick() },
                onDraw = {

                    translate(
                        left = size.width / 2,
                        top = size.height / 2,
                        block = {

                            stars.value.forEachIndexed { index, it ->

                                it.show(scope = this@Canvas, constraints = constraints, index)
                            }
                        })

                }
            )

            Button(onClick = { pause.value = !pause.value }) {
                Text(text = "Pause")
            }

            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter),
                value = speed.value,
                valueRange = 0f..100f,
                onValueChange = { speed.value = it }
            )
        }
    )
}
