package com.vn.designsystem.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.color.MyMoneyMateColors

@Composable
fun UnderlinedTextField(
    modifier: Modifier,
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textColor: Color = MyMoneyMateColors.Black,
    unfocusedTextColor: Color = MyMoneyMateColors.Black,
    placeHolderText: String = "",
    placeHolderStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeHolderTextColor: Color = MyMoneyMateColors.Black,
    focusedIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedIndicatorColor: Color = MyMoneyMateColors.Gray,
    onTextChanged: (newVal: String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = text,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = textColor,
            unfocusedTextColor = unfocusedTextColor,
            focusedIndicatorColor = focusedIndicatorColor,
            unfocusedIndicatorColor = unfocusedIndicatorColor
        ),
        textStyle = textStyle,
        placeholder = {
            Text(
                text = placeHolderText,
                style = placeHolderStyle,
                color = placeHolderTextColor
            )
        },
        onValueChange = onTextChanged
    )
}

@Preview
@Composable
fun UnderlinedTextFieldPreview() {
    UnderlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        text = "",
        placeHolderText = "Input amount"
    ) { // Do nothing
    }
}