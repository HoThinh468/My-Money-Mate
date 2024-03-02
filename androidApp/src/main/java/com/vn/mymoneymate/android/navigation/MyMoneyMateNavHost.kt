package com.vn.mymoneymate.android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.vn.budgets.budgetsScreen
import com.vn.mymoneymate.android.ui.MyMoneyMateAppState
import com.vn.mywallet.MY_WALLET_ROUTE
import com.vn.mywallet.myWalletScreen

@Composable
fun MyMoneyMateNavHost(
    appState: MyMoneyMateAppState,
    modifier: Modifier,
    startDestinationRoute: String = MY_WALLET_ROUTE
) {
    NavHost(
        navController = appState.navController,
        modifier = modifier,
        startDestination = startDestinationRoute
    ) {
        myWalletScreen()
        budgetsScreen()
    }
}