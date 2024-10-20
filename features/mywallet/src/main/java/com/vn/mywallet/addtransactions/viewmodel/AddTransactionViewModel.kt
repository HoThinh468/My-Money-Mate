package com.vn.mywallet.addtransactions.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.vn.mywallet.addtransactions.TransactionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal data class AddTransactionUiState(
    val transactionTitle: String = "",
    val transactionType: TransactionType = TransactionType.INCOME,
    val transactionDescription: String = "",
    val transactionAmount: Long = 0L,
    val transactionImages: List<Uri> = emptyList(),
    val transactionDate: Long = System.currentTimeMillis(),
    val transactionTime: Long = System.currentTimeMillis()
)

internal class AddTransactionViewModel : ViewModel() {
    private val _addTransactionUiState = MutableStateFlow(AddTransactionUiState())
    val addTransactionUiState: StateFlow<AddTransactionUiState> =
        _addTransactionUiState.asStateFlow()

    fun updateTransactionTitle(title: String) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionTitle = title
        )
    }

    fun updateTransactionType(type: TransactionType) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionType = type
        )
    }

    fun updateTransactionDescription(description: String) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionDescription = description
        )
    }

    fun updateTransactionAmount(amount: Long) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionAmount = amount
        )
    }

    fun updateTransactionImages(uris: List<Uri>) {
        val images = _addTransactionUiState.value.transactionImages.toMutableList()
        for (uri in uris) {
            if (!images.contains(uri)) {
                images.add(uri)
            }
        }
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionImages = images
        )
    }

    fun removeTransactionImages(imageIndex: Int) {
        val images = _addTransactionUiState.value.transactionImages.toMutableList()
        images.removeAt(imageIndex)
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionImages = images
        )
    }

    fun updateSelectedDate(selectedDate: Long?) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionDate = selectedDate ?: System.currentTimeMillis()
        )
    }

    fun updateSelectedTime(selectedTime: Long) {
        _addTransactionUiState.value = _addTransactionUiState.value.copy(
            transactionTime = selectedTime
        )
    }
}