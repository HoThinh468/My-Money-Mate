package com.vn.designsystem.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.dimension.extraSmallSpacing
import com.vn.designsystem.dimension.smallIconSize

@Composable
fun ButtonWithIcon(
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
    buttonText: String,
    @DrawableRes iconRes: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
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

@Preview
@Composable
private fun ButtonWithIconPreview() {
    ButtonWithIcon(
        buttonText = "Save",
        iconRes = com.vn.designsystem.R.drawable.ic_done,
        onClick = { /* Do nothing */ }
    )
}
