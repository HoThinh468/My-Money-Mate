package com.vn.designsystem.components.textfields

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.color.MyMoneyMateColors

@Composable
fun UnBorderTextField(
    modifier: Modifier,
    text: String,
    onTextChanged: (newVal: String) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textColor: Color = MyMoneyMateColors.Black,
    placeHolderText: String = "",
    placeHolderStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeHolderTextColor: Color = MyMoneyMateColors.Gray,
    maxLines: Int = 10
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChanged,
        placeholder = {
            Text(
                text = placeHolderText,
                style = placeHolderStyle,
                color = placeHolderTextColor
            )
        },
        textStyle = textStyle,
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = maxLines
    )
}

@Preview
@Composable
private fun UnBorderTextFieldPreview() {
    UnBorderTextField(
        modifier = Modifier,
        text = "Simple preview text field",
        onTextChanged = { /* Do nothing */ }
    )
}