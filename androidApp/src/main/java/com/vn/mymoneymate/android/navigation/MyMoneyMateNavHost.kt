package com.vn.mymoneymate.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.vn.budgets.budgetsScreen
import com.vn.mymoneymate.android.MyMoneyMateAppState
import com.vn.mywallet.MY_WALLET_ROUTE
import com.vn.mywallet.myWalletScreen
import com.vn.mywallet.transactions.addTransactionsScreen
import com.vn.report.reportScreen

@Composable
fun MyMoneyMateNavHost(
    appState: MyMoneyMateAppState,
    modifier: Modifier,
    startDestinationRoute: String = MY_WALLET_ROUTE
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestinationRoute
    ) {
        myWalletScreen()
        budgetsScreen()
        reportScreen()
        addTransactionsScreen(
            onBackClick = navController::popBackStack
        )
    }
}