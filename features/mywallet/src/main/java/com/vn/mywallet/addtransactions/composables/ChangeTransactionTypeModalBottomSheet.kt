package com.vn.mywallet.addtransactions.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.components.cards.FullWidthClickableCardViewWithIcon
import com.vn.designsystem.dimension.extraLargeSpacing
import com.vn.designsystem.dimension.normalSpacing
import com.vn.mywallet.R
import com.vn.mywallet.addtransactions.TransactionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ChangeTransactionTypeModalBottomSheet(
    sheetState: SheetState,
    onDismissModalBottomSheet: (selectedTransactionType: TransactionType?) -> Unit,
    modifier: Modifier = Modifier,
    transactionType: TransactionType = TransactionType.INCOME
) {
    var selectedTransactionType by remember { mutableStateOf(transactionType) }
    ModalBottomSheet(
        onDismissRequest = {
            onDismissModalBottomSheet(null)
        },
        sheetState = sheetState,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = normalSpacing)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.set_transaction_type),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(normalSpacing))
            FullWidthClickableCardViewWithIcon(
                cardTitle = stringResource(id = R.string.income),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_income,
                backgroundColor = if (selectedTransactionType == TransactionType.INCOME) {
                    MaterialTheme.colorScheme.secondary
                } else MaterialTheme.colorScheme.surface,
                contentColor = if (selectedTransactionType == TransactionType.INCOME) {
                    MaterialTheme.colorScheme.onSecondary
                } else MaterialTheme.colorScheme.onSurface,
                onCardClick = {
                    selectedTransactionType = TransactionType.INCOME
                    onDismissModalBottomSheet(selectedTransactionType)
                }
            )
            Spacer(modifier = Modifier.height(normalSpacing))
            FullWidthClickableCardViewWithIcon(
                cardTitle = stringResource(id = R.string.expenses),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_expense,
                backgroundColor = if (selectedTransactionType == TransactionType.EXPENSE) {
                    MaterialTheme.colorScheme.secondary
                } else MaterialTheme.colorScheme.surface,
                contentColor = if (selectedTransactionType == TransactionType.EXPENSE) {
                    MaterialTheme.colorScheme.onSecondary
                } else MaterialTheme.colorScheme.onSurface,
                onCardClick = {
                    selectedTransactionType = TransactionType.EXPENSE
                    onDismissModalBottomSheet(selectedTransactionType)
                }
            )
            Spacer(modifier = Modifier.height(extraLargeSpacing))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun ChangeTransactionTypeModalBottomSheetPreview() {
    ChangeTransactionTypeModalBottomSheet(
        sheetState = rememberModalBottomSheetState(),
        onDismissModalBottomSheet = {
            // Do nothing
        }
    )
}
