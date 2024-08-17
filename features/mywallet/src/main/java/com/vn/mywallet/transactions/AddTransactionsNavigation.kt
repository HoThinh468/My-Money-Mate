package com.vn.mywallet.transactions

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ADD_TRANSACTIONS_ROUTE = "add_transactions"

fun NavController.navigateToAddTransactionsScreen() = navigate(ADD_TRANSACTIONS_ROUTE)

fun NavGraphBuilder.addTransactionsScreen(
    onBackClick: () -> Unit
) {
    composable(ADD_TRANSACTIONS_ROUTE) {
        AddTransactionsScreen {
            onBackClick()
        }
    }
}