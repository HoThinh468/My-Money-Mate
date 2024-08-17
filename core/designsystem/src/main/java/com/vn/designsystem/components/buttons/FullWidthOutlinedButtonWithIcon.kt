package com.vn.designsystem.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FullWidthOutlinedButtonWithIcon(
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

}