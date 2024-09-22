package com.vn.mywallet.transactions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.designsystem.components.textfields.UnderlinedAmountInputTextField
import com.vn.designsystem.dimension.mediumSpacing
import com.vn.designsystem.dimension.normalSpacing
import com.vn.mywallet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMoneyAmountModalBottomSheet(
    sheetState: SheetState,
    onSaveAmount: (amount: Long) -> Unit,
    onDismiss: () -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() }
    ) {
        var amount by rememberSaveable { mutableStateOf("") }

        UnderlinedAmountInputTextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (it.isFocused) {
                        keyboardController?.show()
                    }
                }
                .padding(start = mediumSpacing, bottom = normalSpacing, end = mediumSpacing),
            text = amount,
            placeHolderText = "0",
            textStyle = MaterialTheme.typography.titleLarge.copy(
                textAlign = TextAlign.Center
            ),
            placeHolderStyle = MaterialTheme.typography.titleLarge,
            placeHolderTextAlign = TextAlign.Center,
            placeHolderTextColor = MyMoneyMateColors.Black,
            labelAlign = TextAlign.Center,
            labelText = stringResource(id = R.string.input_amount),
            onTextChanged = {
                amount = it
            },
            keyboardActions = KeyboardActions {
                onSaveAmount(amount.toLong())
                onDismiss()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun EditMoneyAmountModalBottomSheetPreview() {
    AddMoneyAmountModalBottomSheet(
        sheetState = rememberModalBottomSheetState(),
        onDismiss = { /* Do nothing */ },
        onSaveAmount = { /* Do nothing */ }
    )
}
