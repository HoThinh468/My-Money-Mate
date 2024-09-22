package com.vn.designsystem.components.textfields

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.mymoneymate.util.RegextPatterns

@Composable
fun UnderlinedAmountInputTextField(
    modifier: Modifier,
    text: String,
    onTextChanged: (newVal: String) -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    textColor: Color = MyMoneyMateColors.Black,
    unfocusedTextColor: Color = MyMoneyMateColors.Black,
    placeHolderText: String = "",
    placeHolderStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeHolderTextColor: Color = MyMoneyMateColors.Gray,
    labelText: String = "",
    labelStyle: TextStyle = MaterialTheme.typography.labelSmall,
    labelColor: Color = MyMoneyMateColors.Black,
    focusedIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedIndicatorColor: Color = MyMoneyMateColors.Gray,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    placeHolderTextAlign: TextAlign = TextAlign.Left,
    labelAlign: TextAlign = TextAlign.Left,
    showCursor: Boolean = false
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (labelText.isNotEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = labelText,
                style = labelStyle,
                color = labelColor,
                textAlign = labelAlign
            )
        }
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = text,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = textColor,
                unfocusedTextColor = unfocusedTextColor,
                focusedIndicatorColor = focusedIndicatorColor,
                unfocusedIndicatorColor = unfocusedIndicatorColor,
                cursorColor = if (!showCursor) Color.Transparent else MaterialTheme.colorScheme.primary
            ),
            textStyle = textStyle,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeHolderText,
                    style = placeHolderStyle,
                    color = placeHolderTextColor,
                    textAlign = placeHolderTextAlign
                )
            },
            onValueChange = {
                if (it.matches(Regex(RegextPatterns.AMOUNT_REGEX))) {
                    onTextChanged(it)
                }
            },
            keyboardActions = keyboardActions,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            maxLines = 1
        )
    }
}

@Preview
@Composable
private fun UnderlinedAmountInputTextFieldPreview() {
    UnderlinedAmountInputTextField(
        modifier = Modifier.fillMaxWidth(),
        text = "",
        placeHolderText = "Input amount",
        onTextChanged = { /* Do nothing */ }
    )
}