package com.mvk.common.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

internal val Mine: Color = Color(0xFF3d3838)
internal val Boulder: Color = Color(0xFF777777)
internal val Grey: Color = Color(0xFF707070)
internal val Bunker: Color = Color(0xFF0e161a)
internal val OceanBlue: Color = Color(0xFF174673)
internal val SeaBlue: Color = Color(0xFF14427e)
internal val DodgerBlue: Color = Color(0xFF33b1ff)
internal val Selago: Color = Color(0xFFecf4fc)
internal val Sliver: Color = Color(0xFFcbcbcb)
internal val Mercury: Color = Color(0xFFe8e8e8)
internal val Geyser: Color = Color(0xFFd9e1e6)
internal val Tangerine: Color = Color(0xFFe58e00)
internal val Green: Color = Color(0xFF328b4d)
internal val Crimson: Color = Color(0xFFda1e28)

internal val LightColorPalette: Colors = lightColors(

    primary = SeaBlue,
    onPrimary = Color.White,
    primaryVariant = OceanBlue,

    secondary = Selago,
    onSecondary = SeaBlue,
    secondaryVariant = Selago,

    background = Color.White,
    onBackground = Mine,

    surface = Color.White,
    onSurface = Mine,
)
