package com.vn.mywallet.addtransactions.composables

import android.icu.util.Calendar
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vn.designsystem.color.MyMoneyMateColors
import com.vn.designsystem.components.FullWidthFilledPrimaryButton
import com.vn.designsystem.components.SmallTopAppBar
import com.vn.designsystem.components.buttons.OutlinedButtonWithIcon
import com.vn.designsystem.components.cards.FullWidthClickableCardViewWithIcon
import com.vn.designsystem.components.pickers.SimpleDatePickerModal
import com.vn.designsystem.components.pickers.SimpleTimePickerModal
import com.vn.designsystem.components.textfields.UnderlinedTextField
import com.vn.designsystem.dimension.mediumSpacing
import com.vn.designsystem.dimension.normalSpacing
import com.vn.designsystem.dimension.smallSpacing
import com.vn.mywallet.R
import com.vn.mywallet.addtransactions.TransactionType
import com.vn.mywallet.addtransactions.viewmodel.AddTransactionUiState
import com.vn.mywallet.addtransactions.viewmodel.AddTransactionViewModel
import com.vn.utility.DateTimeFormatter
import java.time.LocalDateTime

@Composable
internal fun AddTransactionsScreen(
    modifier: Modifier = Modifier,
    onNavigationBack: () -> Unit,
    viewModel: AddTransactionViewModel = viewModel()
) {
    val addTransactionUiState by viewModel.addTransactionUiState.collectAsState()
    val maxTransactionImageCount = integerResource(id = R.integer.max_transaction_image_count)
    val multiImagesPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(maxTransactionImageCount)
    ) { uris: List<Uri> ->
        if (uris.isNotEmpty()) {
            viewModel.updateTransactionImages(uris)
        }
    }

    AddTransactionsContent(
        modifier = modifier,
        addTransactionUiState = addTransactionUiState,
        maxTransactionImageCount = maxTransactionImageCount,
        formattedDate = DateTimeFormatter.formatDate(addTransactionUiState.transactionDate),
        formattedTime = DateTimeFormatter.formatTime(addTransactionUiState.transactionTime),
        onNavigationBack = onNavigationBack,
        onImagePickerClick = {
            multiImagesPickerLauncher.launch(
                PickVisualMediaRequest(
                    mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                )
            )
        },
        onSaveTransactionTitle = viewModel::updateTransactionTitle,
        onSaveTransactionType = viewModel::updateTransactionType,
        onSaveTransactionDescription = viewModel::updateTransactionDescription,
        onSaveTransactionAmount = viewModel::updateTransactionAmount,
        onRemoveImageAt = viewModel::removeTransactionImages,
        onDateSelected = viewModel::updateSelectedDate,
        onTimeSelected = viewModel::updateSelectedTime
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddTransactionsContent(
    modifier: Modifier,
    addTransactionUiState: AddTransactionUiState,
    maxTransactionImageCount: Int,
    formattedDate: String,
    formattedTime: String,
    onNavigationBack: () -> Unit,
    onImagePickerClick: () -> Unit,
    onSaveTransactionTitle: (title: String) -> Unit,
    onSaveTransactionDescription: (description: String) -> Unit,
    onSaveTransactionType: (type: TransactionType) -> Unit,
    onSaveTransactionAmount: (amount: Long) -> Unit,
    onRemoveImageAt: (index: Int) -> Unit,
    onDateSelected: (date: Long?) -> Unit,
    onTimeSelected: (time: Long) -> Unit
) {
    val focusRequester = remember {
        FocusRequester()
    }
    var showTransactionTypeModalBottomSheet by remember {
        mutableStateOf(false)
    }
    var showAddMoneyAmountModalBottomSheet by remember {
        mutableStateOf(false)
    }
    var showAddTransactionDescriptionModalBottomSheet by remember {
        mutableStateOf(false)
    }
    var showDatePickerDialog by remember {
        mutableStateOf(false)
    }
    var showTimePickerDialog by remember {
        mutableStateOf(false)
    }

    val focusManager = LocalFocusManager.current
    val sheetState = rememberModalBottomSheetState()
    val currentTime = LocalDateTime.now()

    if (showDatePickerDialog) {
        SimpleDatePickerModal(
            onDismiss = {
                showDatePickerDialog = false
            },
            onDateSelected = {
                onDateSelected(it)
            }
        )
    }

    if (showTimePickerDialog) {
        SimpleTimePickerModal(
            initialHour = currentTime.hour,
            initialMinute = currentTime.minute,
            onDismiss = {
                showTimePickerDialog = false
            },
            onTimeSelected = { hour, minute ->
                val calendar = Calendar.getInstance().apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                onTimeSelected(calendar.timeInMillis)
            }
        )
    }

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
                        buttonText = stringResource(
                            id = if (addTransactionUiState.transactionType == TransactionType.INCOME) {
                                R.string.income
                            } else {
                                R.string.expenses
                            }
                        ),
                        iconRes = if (addTransactionUiState.transactionType == TransactionType.INCOME) {
                            com.vn.designsystem.R.drawable.ic_income
                        } else com.vn.designsystem.R.drawable.ic_expense,
                        borderColor = MyMoneyMateColors.Gray
                    ) {
                        showTransactionTypeModalBottomSheet = true
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
        if (showTransactionTypeModalBottomSheet) {
            ChangeTransactionTypeModalBottomSheet(
                sheetState = sheetState,
                onDismissModalBottomSheet = { type ->
                    showTransactionTypeModalBottomSheet = false
                    if (type != null) {
                        onSaveTransactionType(type)
                    }
                },
                transactionType = addTransactionUiState.transactionType
            )
        }
        if (showAddMoneyAmountModalBottomSheet) {
            AddMoneyAmountModalBottomSheet(
                sheetState = sheetState,
                onSaveAmount = { amount ->
                    onSaveTransactionAmount(amount)
                },
                onDismiss = {
                    showAddMoneyAmountModalBottomSheet = false
                }
            )
        }
        if (showAddTransactionDescriptionModalBottomSheet) {
            AddTransactionDescriptionModalBottomSheet(
                sheetState = sheetState,
                onSaveDescription = { description ->
                    onSaveTransactionDescription(description)
                },
                onDismiss = {
                    showAddTransactionDescriptionModalBottomSheet = false
                },
                description = addTransactionUiState.transactionDescription
            )
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
                text = addTransactionUiState.transactionTitle,
                textStyle = MaterialTheme.typography.titleLarge,
                placeHolderStyle = MaterialTheme.typography.titleLarge,
                placeHolderText = stringResource(id = R.string.transaction_title),
                onTextChanged = { title ->
                    onSaveTransactionTitle(title)
                }
            )
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
                buttonText = formattedDate,
                iconRes = com.vn.designsystem.R.drawable.ic_edit_calendar,
                borderColor = MaterialTheme.colorScheme.onBackground,
                borderWidth = 2.dp
            ) {
                showDatePickerDialog = true
            }
            Spacer(modifier = Modifier.height(smallSpacing))
            OutlinedButtonWithIcon(
                modifier = Modifier.padding(horizontal = mediumSpacing),
                buttonText = formattedTime,
                iconRes = com.vn.designsystem.R.drawable.ic_access_time,
                borderColor = MaterialTheme.colorScheme.onBackground,
                borderWidth = 2.dp
            ) {
                showTimePickerDialog = true
            }
            Spacer(modifier = Modifier.height(normalSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_payments,
                trailingIconRes = com.vn.designsystem.R.drawable.ic_us_dollar_sign,
                cardTitle = addTransactionUiState.transactionAmount.toString(),
                onCardClick = {
                    showAddMoneyAmountModalBottomSheet = true
                }
            )
            Spacer(modifier = Modifier.height(mediumSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_notes,
                cardTitle = stringResource(id = R.string.add_description),
                onCardClick = {
                    showAddTransactionDescriptionModalBottomSheet = true
                },
                cardContent = if (addTransactionUiState.transactionDescription.isNotEmpty()) {
                    {
                        Text(
                            text = addTransactionUiState.transactionDescription,
                            style = MaterialTheme.typography.displayMedium
                        )
                    }
                } else null
            )
            Spacer(modifier = Modifier.height(mediumSpacing))
            FullWidthClickableCardViewWithIcon(
                modifier = Modifier
                    .padding(horizontal = mediumSpacing)
                    .fillMaxWidth(),
                leadingIconRes = com.vn.designsystem.R.drawable.ic_attachment,
                cardTitle = stringResource(id = R.string.add_image),
                onCardClick = {
                    onImagePickerClick()
                },
                trailingComposable = {
                    Text(
                        text = "${addTransactionUiState.transactionImages.size}/$maxTransactionImageCount",
                        style = MaterialTheme.typography.displayMedium
                    )
                },
                cardContent = if (addTransactionUiState.transactionImages.isNotEmpty()) {
                    {
                        LazyRow {
                            for ((index, imageUri) in addTransactionUiState.transactionImages.withIndex()) {
                                item {
                                    TransactionImagePreviewItem(
                                        uri = imageUri,
                                        onCloseButtonClick = {
                                            onRemoveImageAt(index)
                                        },
                                        onFullScreenButtonClick = { /*Open a full image screen*/ }
                                    )
                                    if (index < addTransactionUiState.transactionImages.size - 1) {
                                        Spacer(modifier = Modifier.width(smallSpacing))
                                    }
                                }
                            }
                        }
                    }
                } else null
            )
        }
    }
}

@Preview
@Composable
private fun AddTransactionsScreenPreview() {
    AddTransactionsScreen(
        onNavigationBack = { /* Do nothing */ }
    )
}
