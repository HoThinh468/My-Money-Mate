package com.vn.designsystem.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
object MyMoneyMateColors {
    val White = Color(0xFFFAFAFC)
    val ExtraLightGray = Color(0xFFEBEBF0)
    val LightGray = Color(0xFFCBCBD6)
    val Gray = Color(0xFF74747A)
    val DarkGray = Color(0xFF303033)
    val ExtraDarkGray = Color(0xFF1C1C1F)
    val Black = Color(0xFF09090A)

    val Purple = ColorShades(
        light = Color(0xFFE1AFD1),
        primary = Color(0xFFAD88C6),
        dark = Color(0xFF7469B6)
    )

    val Red = ColorShades(
        light = Color(0xFFF5AB87),
        primary = Color(0xFFF53D3D),
        dark = Color(0xFF8F2424)
    )

    val Orange = ColorShades(
        light = Color(0xFFF5AB87),
        primary = Color(0xFFF57A3D),
        dark = Color(0xFF8F4724)
    )

    val Green = ColorShades(
        light = Color(0xFF5AE0B4),
        primary = Color(0xFF12B880),
        dark = Color(0xFF0C7A56)
    )

    val Blue = ColorShades(
        light = Color(0xFF87BEF5),
        primary = Color(0xFF3193F5),
        dark = Color(0xFF24598F)
    )

    val Teal = ColorShades(
        light = Color(0xFF80B9AD),
        primary = Color(0xFF6295A2),
        dark = Color(0xFF538392)
    )
}