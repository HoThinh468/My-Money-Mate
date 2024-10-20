package com.vn.designsystem.components.pickers

import androidx.annotation.StringRes
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDatePickerModal(
    onDismiss: () -> Unit,
    onDateSelected: (Long?) -> Unit,
    datePickerState: DatePickerState = rememberDatePickerState(),
    @StringRes confirmButtonTextRes: Int = android.R.string.ok,
    @StringRes dismissButtonTextRes: Int = android.R.string.cancel
) {
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text(stringResource(id = confirmButtonTextRes))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(id = dismissButtonTextRes))
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}