package com.vn.mymoneymate.android.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.vn.budgets.BUDGETS_ROUTE
import com.vn.mymoneymate.android.R
import com.vn.mywallet.MY_WALLET_ROUTE
import com.vn.report.REPORT_ROUTE

enum class TopLevelDestination(
    val route: String,
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    MY_WALLET_SCREEN(MY_WALLET_ROUTE, R.string.wallet_label, R.drawable.ic_wallet),
    BUDGETS_SCREEN(BUDGETS_ROUTE, R.string.budget_label, R.drawable.ic_payment),
    REPORT_SCREEN(REPORT_ROUTE, R.string.report_label, R.drawable.ic_bar_chart);

    companion object {
        fun getCurrentTopLevelDestination(route: String?): TopLevelDestination? = when (route) {
            MY_WALLET_SCREEN.route -> MY_WALLET_SCREEN
            BUDGETS_SCREEN.route -> BUDGETS_SCREEN
            REPORT_SCREEN.route -> REPORT_SCREEN
            else -> null
        }
    }
}
