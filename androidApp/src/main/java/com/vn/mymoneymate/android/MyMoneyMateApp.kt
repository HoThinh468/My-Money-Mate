package com.vn.mymoneymate.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vn.designsystem.components.MyMoneyMateSuperFab
import com.vn.designsystem.theme.MyMoneyMateTheme
import com.vn.mymoneymate.android.navigation.BottomNavBar
import com.vn.mymoneymate.android.navigation.MyMoneyMateNavHost

@Composable
fun MyMoneyMateApp() {
    MyMoneyMateTheme {
        val appState = rememberAppState()

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            floatingActionButton = {
                MyMoneyMateSuperFab { // TODO Show add transaction screen
                }
            },
            bottomBar = {
                BottomNavBar(
                    appState.navController,
                    appState.currentDestination,
                    appState.topLevelDestinations
                )
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