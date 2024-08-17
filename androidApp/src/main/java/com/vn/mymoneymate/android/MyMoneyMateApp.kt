package com.vn.mymoneymate.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vn.designsystem.components.MyMoneyMateFab
import com.vn.designsystem.theme.MyMoneyMateTheme
import com.vn.mymoneymate.android.navigation.MyMoneyMateBottomNavBar
import com.vn.mymoneymate.android.navigation.MyMoneyMateNavHost
import com.vn.mywallet.transactions.navigateToAddTransactionsScreen

@Composable
fun MyMoneyMateApp() {
    MyMoneyMateTheme {
        val appState = rememberAppState()
        val navController = appState.navController

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            floatingActionButton = {
                if (appState.isAtTopDestination) {
                    MyMoneyMateFab {
                        navController.navigateToAddTransactionsScreen()
                    }
                }
            },
            bottomBar = {
                if (appState.isAtTopDestination) {
                    MyMoneyMateBottomNavBar(
                        navController,
                        appState.currentDestination,
                        appState.topLevelDestinations
                    )
                }
            },
        ) { innerPadding ->
            MyMoneyMateNavHost(
                appState = appState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}