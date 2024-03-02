package com.vn.mywallet

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val MY_WALLET_ROUTE = "my_wallet"

fun NavController.navigateToMyWallet() = navigate(MY_WALLET_ROUTE)

fun NavGraphBuilder.myWalletScreen() {
    composable(MY_WALLET_ROUTE) {
        MyWalletScreen()
    }
}
