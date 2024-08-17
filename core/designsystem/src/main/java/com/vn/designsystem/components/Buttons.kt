package com.vn.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Stable
@Composable
fun MyMoneyMateFab(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(modifier = modifier, onClick = onClick, shape = CircleShape) {
        Icon(Icons.Filled.Add, contentDescription = "Floating button")
    }
}

@Preview
@Composable
fun MyMoneyMateFabPreview() {
    MyMoneyMateFab {
        // Do nothing
    }
}

@Composable
fun FullWidthFilledPrimaryButton(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    enabled: Boolean = true,
    content: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(text = content)
    }
}

@Preview
@Composable
fun FullWidthFilledPrimaryButtonPreview() {
    FullWidthFilledPrimaryButton(content = "SAVE") {
        // Do nothing
    }
}
