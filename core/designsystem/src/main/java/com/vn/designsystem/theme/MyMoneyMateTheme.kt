package com.vn.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.designsystem.dimension.bodyMediumTextSize
import com.vn.designsystem.dimension.bodySmallTextSize
import com.vn.designsystem.dimension.displayMediumTextSize
import com.vn.designsystem.dimension.displaySmallTextSize
import com.vn.designsystem.dimension.extraLargeRadius
import com.vn.designsystem.dimension.extraLargeTextSize
import com.vn.designsystem.dimension.extraSmallRadius
import com.vn.designsystem.dimension.largeRadius
import com.vn.designsystem.dimension.largeTextSize
import com.vn.designsystem.dimension.mediumRadius
import com.vn.designsystem.dimension.mediumTitleTextSize
import com.vn.designsystem.dimension.smallRadius
import com.vn.designsystem.dimension.smallTitleTextSize

private fun myMoneyMateLightColorScheme(): ColorScheme {
    return lightColorScheme(
        primary = MyMoneyMateColors.Purple.primary,
        onPrimary = MyMoneyMateColors.White,
        primaryContainer = MyMoneyMateColors.Purple.light,
        onPrimaryContainer = MyMoneyMateColors.White,
        secondary = MyMoneyMateColors.Green.light,
        onSecondary = MyMoneyMateColors.White,
        secondaryContainer = MyMoneyMateColors.Blue.light,
        onSecondaryContainer = MyMoneyMateColors.White,
        tertiary = MyMoneyMateColors.Teal.primary,
        onTertiary = MyMoneyMateColors.White,
        tertiaryContainer = MyMoneyMateColors.Blue.primary,
        onTertiaryContainer = MyMoneyMateColors.Orange.light,

        error = MyMoneyMateColors.Red.primary,
        onError = MyMoneyMateColors.White,
        errorContainer = MyMoneyMateColors.Red.light,
        onErrorContainer = MyMoneyMateColors.White,

        background = MyMoneyMateColors.White,
        onBackground = MyMoneyMateColors.Black,
        surface = MyMoneyMateColors.ExtraLightGray,
        onSurface = MyMoneyMateColors.Black,
        surfaceVariant = MyMoneyMateColors.LightGray,
        onSurfaceVariant = MyMoneyMateColors.Black,
        inverseSurface = MyMoneyMateColors.DarkGray,

        outline = MyMoneyMateColors.Gray,
        outlineVariant = MyMoneyMateColors.DarkGray,
        scrim = MyMoneyMateColors.ExtraDarkGray
    )
}

private fun myMoneyMateDarkColorScheme(): ColorScheme {
    return darkColorScheme(
        primary = MyMoneyMateColors.Purple.dark,
        onPrimary = MyMoneyMateColors.White,
        primaryContainer = MyMoneyMateColors.Green.dark,
        onPrimaryContainer = MyMoneyMateColors.White,
        secondary = MyMoneyMateColors.Orange.dark,
        onSecondary = MyMoneyMateColors.White,
        secondaryContainer = MyMoneyMateColors.Blue.dark,
        onSecondaryContainer = MyMoneyMateColors.White,
        tertiary = MyMoneyMateColors.Teal.dark,
        onTertiary = MyMoneyMateColors.White,
        tertiaryContainer = MyMoneyMateColors.Blue.dark,
        onTertiaryContainer = MyMoneyMateColors.Orange.dark,

        error = MyMoneyMateColors.Red.primary,
        onError = MyMoneyMateColors.White,
        errorContainer = MyMoneyMateColors.Red.dark,
        onErrorContainer = MyMoneyMateColors.White,

        background = MyMoneyMateColors.Black,
        onBackground = MyMoneyMateColors.White,
        surface = MyMoneyMateColors.LightGray,
        onSurface = MyMoneyMateColors.Black,
        surfaceVariant = MyMoneyMateColors.ExtraDarkGray,
        onSurfaceVariant = MyMoneyMateColors.Black,
        inverseSurface = MyMoneyMateColors.LightGray,

        outline = MyMoneyMateColors.DarkGray,
        outlineVariant = MyMoneyMateColors.LightGray,
        scrim = MyMoneyMateColors.Gray
    )
}

private fun myMoneyMateTypography(): Typography {
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            fontSize = extraLargeTextSize
        ),
        titleLarge = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = largeTextSize
        ),
        titleMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = mediumTitleTextSize
        ),
        titleSmall = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = smallTitleTextSize
        ),
        bodyMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = bodyMediumTextSize
        ),
        bodySmall = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = bodySmallTextSize
        ),
        displayMedium = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = displayMediumTextSize
        ),
        displaySmall = TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Light,
            fontSize = displaySmallTextSize
        )
    )
}

private fun myMoneyMateShape(): Shapes {
    return Shapes(
        extraLarge = RoundedCornerShape(extraLargeRadius),
        large = RoundedCornerShape(largeRadius),
        medium = RoundedCornerShape(mediumRadius),
        small = RoundedCornerShape(smallRadius),
        extraSmall = RoundedCornerShape(extraSmallRadius)
    )
}

@Composable
fun MyMoneyMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) myMoneyMateDarkColorScheme()
        else myMoneyMateLightColorScheme(),
        typography = myMoneyMateTypography(),
        shapes = myMoneyMateShape(),
        content = content
    )
}
