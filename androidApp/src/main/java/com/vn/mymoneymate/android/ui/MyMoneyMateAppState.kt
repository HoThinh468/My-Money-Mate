package com.vn.mymoneymate.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vn.mymoneymate.android.navigation.TopLevelDestination

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
): MyMoneyMateAppState {
    return remember {
        MyMoneyMateAppState(navController)
    }
}

@Stable
class MyMoneyMateAppState(val navController: NavHostController) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = TopLevelDestination.getCurrentTopLevelDestination(currentDestination?.route)

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries
}