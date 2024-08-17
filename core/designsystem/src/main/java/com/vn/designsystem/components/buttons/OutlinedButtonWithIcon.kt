package com.vn.designsystem.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vn.designsystem.dimension.extraSmallSpacing
import com.vn.designsystem.dimension.smallIconSize
import com.vn.designsystem.dimension.tinySpacing

@Composable
fun OutlinedButtonWithIcon(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    borderColor: Color = MaterialTheme.colorScheme.onBackground,
    borderWidth: Dp = 1.dp,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    buttonText: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        border = BorderStroke(color = borderColor, width = borderWidth)
    ) {
        Icon(
            modifier = Modifier.size(smallIconSize),
            painter = painterResource(id = iconRes),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(extraSmallSpacing))
        Text(text = buttonText, style = textStyle)
    }
}
