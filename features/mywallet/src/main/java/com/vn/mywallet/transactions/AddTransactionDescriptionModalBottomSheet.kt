package com.vn.mywallet.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.components.buttons.ButtonWithIcon
import com.vn.designsystem.components.textfields.UnBorderTextField
import com.vn.designsystem.dimension.normalSpacing
import com.vn.designsystem.dimension.tinySpacing
import com.vn.mywallet.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTransactionDescriptionModalBottomSheet(
    onDismiss: () -> Unit,
    onSaveDescription: (description: String) -> Unit,
    sheetState: SheetState,
    modifier: Modifier = Modifier,
    description: String = ""
) {
    val (newDescription, setNewDescription) = remember { mutableStateOf(description) }
    val descriptionMaxLength = integerResource(id = R.integer.transaction_description_max_length)
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = Unit) {
        focusRequester.requestFocus()
    }

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() }
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(horizontal = normalSpacing),
                text = stringResource(id = R.string.description_title),
                style = MaterialTheme.typography.titleMedium
            )
            UnBorderTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        if (it.isFocused) {
                            keyboardController?.show()
                        }
                    }
                    .padding(horizontal = tinySpacing),
                text = newDescription,
                onTextChanged = {
                    if (it.length <= descriptionMaxLength) {
                        setNewDescription(it)
                    }
                },
                placeHolderText = stringResource(id = R.string.add_description_place_holder_text)
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = normalSpacing, end = normalSpacing, bottom = normalSpacing),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${newDescription.length}/${integerResource(id = R.integer.transaction_description_max_length)}",
                    style = MaterialTheme.typography.displayMedium
                )
                ButtonWithIcon(
                    buttonText = stringResource(id = R.string.save_button_text),
                    iconRes = com.vn.designsystem.R.drawable.ic_done
                ) {
                    onSaveDescription(newDescription)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun AddTransactionDescriptionModalBottomSheetPreview() {
    AddTransactionDescriptionModalBottomSheet(
        onDismiss = { /* Do nothing */ },
        onSaveDescription = { /* Do nothing */ },
        sheetState = remember { SheetState(skipPartiallyExpanded = true) }
    )
}
