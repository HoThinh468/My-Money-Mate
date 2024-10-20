package com.vn.designsystem.components.pickers

import androidx.annotation.StringRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTimePickerModal(
    onTimeSelected: (hour: Int, minute: Int) -> Unit,
    onDismiss: () -> Unit,
    @StringRes confirmButtonTextRes: Int = android.R.string.ok,
    @StringRes dismissButtonTextRes: Int = android.R.string.cancel,
    initialHour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
    initialMinute: Int = Calendar.getInstance().get(Calendar.MINUTE),
    is24Hour: Boolean = true
) {
    val timePickerState = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = is24Hour,
    )

    TimePickerDialog(
        onDismiss = { onDismiss() },
        onConfirm = {
            onTimeSelected(timePickerState.hour, timePickerState.minute)
            onDismiss()
        },
        content = {
            TimePicker(
                state = timePickerState,
            )
        },
        confirmButtonTextRes = confirmButtonTextRes,
        dismissButtonTextRes = dismissButtonTextRes
    )
}

@Composable
private fun TimePickerDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    content: @Composable () -> Unit,
    @StringRes confirmButtonTextRes: Int,
    @StringRes dismissButtonTextRes: Int
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(id = dismissButtonTextRes))
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(stringResource(id = confirmButtonTextRes))
            }
        },
        text = { content() }
    )
}