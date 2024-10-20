package com.vn.mywallet.addtransactions

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vn.mywallet.addtransactions.composables.AddTransactionsScreen

private const val ADD_TRANSACTIONS_ROUTE = "add_transactions"

fun NavController.navigateToAddTransactionsScreen() = navigate(ADD_TRANSACTIONS_ROUTE)

fun NavGraphBuilder.addTransactionsScreen(
    onBackClick: () -> Unit
) {
    composable(ADD_TRANSACTIONS_ROUTE) {
        AddTransactionsScreen(
            onNavigationBack = {
                onBackClick()
            }
        )
    }
}