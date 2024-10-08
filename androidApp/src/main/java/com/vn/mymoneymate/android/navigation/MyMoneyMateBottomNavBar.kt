package com.vn.mymoneymate.android.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController

@Composable
fun MyMoneyMateBottomNavBar(
    navController: NavController,
    currentDestination: NavDestination?,
    topLevelDestinations: List<TopLevelDestination>
) {
    NavigationBar {
        topLevelDestinations.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = screen.label))
                }
            )
        }
    }
}

@Preview
@Composable
fun MyMoneyMateBottomNavBarPreview() {
    MyMoneyMateBottomNavBar(
        rememberNavController(),
        null,
        TopLevelDestination.entries
    )
}
