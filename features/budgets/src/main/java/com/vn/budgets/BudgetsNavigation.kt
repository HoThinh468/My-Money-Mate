package com.vn.budgets

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val BUDGETS_ROUTE = "budgets"

fun NavController.navigateToBudgets() = navigate(BUDGETS_ROUTE)

fun NavGraphBuilder.budgetsScreen() {
    composable(BUDGETS_ROUTE) {
        BudgetsScreen()
    }
}
