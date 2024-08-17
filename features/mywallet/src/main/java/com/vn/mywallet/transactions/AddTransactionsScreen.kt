package com.vn.mywallet.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.designsystem.components.FullWidthFilledPrimaryButton
import com.vn.designsystem.components.SmallTopAppBar
import com.vn.designsystem.components.buttons.OutlinedButtonWithIcon
import com.vn.designsystem.components.cards.FullWidthClickableCardViewWithIcon
import com.vn.designsystem.components.textfields.UnderlinedTextField
import com.vn.designsystem.dimension.mediumSpacing
import com.vn.designsystem.dimension.normalSpacing
import com.vn.designsystem.dimension.smallSpacing
import com.vn.mywallet.R

@Composable
fun AddTransactionsScreen(
    modifier: Modifier = Modifier,
    onNavigationBack: () -> Unit
) {
    AddTransactionsContent(modifier = modifier) {
        onNavigationBack()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddTransactionsContent(
    modifier: Modifier,
    onNavigationBack: () -> Unit
) {
    var transactionTitle by remember {
        mutableStateOf("")
    }
    val focusRequester = remember {
        FocusRequester()
    }
    val focusManager = LocalFocusManager.current
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(Unit) {
                detectTapGestures {
                    focusManager.clearFocus()
                }
            },
        topBar = {
            SmallTopAppBar(
                navigationIcon = Icons.Default.Close,
                actionComposable = {
                    OutlinedButtonWithIcon(
                        buttonText = stringResource(id = R.string.income),
                        iconRes = com.vn.designsystem.R.drawable.ic_income,
                        borderColor = MyMoneyMateColors.Gray
                    ) {
                        showBottomSheet = true
                    }
                }
            ) {
                onNavigationBack()
            }
        },
        bottomBar = {
            FullWidthFilledPrimaryButton(
                modifier = modifier.padding(normalSpacing),
                content = stringResource(id = R.string.save_button_text)
            ) { // TODO: Save transaction
            }
        }
    ) { innerPadding ->
        if (showBottomSheet) {
            ChangeTransactionTypeModalBottomSheet(sheetState = sheetState) {
                showBottomSheet = false
            }
        }
        Column(
            modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            ) {
            UnderlinedTextField(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .focusRequester(focusRequester)
                    .fillMaxWidth(),
                text = transactionTitle,
                textStyle = MaterialTheme.typography.titleLarge,
                placeHolderStyle = MaterialTheme.typography.titleLarge,
                placeHolderText = stringResource(id = R.string.transaction_title),
                placeHolderTextColor = MyMoneyMateColors.Gray
            ) {
                transactionTitle = it
            }
            Spacer(modifier = Modifier.height(normalSpacing))
            OutlinedButtonWithIcon(
                modifier = Modifier.padding(horizontal = mediumSpacing),
                buttonText = stringResource(id = R.string.add_category),
                iconRes = com.vn.designsystem.R.drawable.ic_transaction_category,
                borderColor = MaterialTheme.colorScheme.onBackground,
                borderWidth = 2.dp
            ) {
                // Show category list screen
            }
            Spacer(modifier = Modifier.height(smallSpacing))
            OutlinedButtonWithIcon(
                modifier = Modifier.padding(horizontal = mediumSpacing),
                buttonText = "25-06-2024",
                iconRes = com.vn.designsystem.R.drawable.ic_edit_calendar,
                borderColor = MaterialTheme.colorScheme.onBackground,
                borderWidth = 2.dp
            ) {
                // Show category list screen
            }
            Spacer(modifier = Modifier.height(normalSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_payments,
                trailingIconRes = com.vn.designsystem.R.drawable.ic_us_dollar_sign,
                cardTitle = "1000"
            ) {
                // Open bottom sheet to add description
            }
            Spacer(modifier = Modifier.height(mediumSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_notes,
                cardTitle = stringResource(id = R.string.add_description)
            ) {
                // Open bottom sheet to add description
            }
            Spacer(modifier = Modifier.height(mediumSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_attachment,
                cardTitle = stringResource(id = R.string.add_image)
            ) {
                // Open camera to request
            }
        }
    }
}

@Preview
@Composable
fun AddTransactionsScreenPreview() {
    AddTransactionsScreen {
        // Do nothing
    }
}
