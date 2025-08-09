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
    MyWalletScreen(MY_WALLET_ROUTE, R.string.wallet_label, R.drawable.ic_wallet),
    BudgetScreen(BUDGETS_ROUTE, R.string.budget_label, R.drawable.ic_payment),
    ReportScreen(REPORT_ROUTE, R.string.report_label, R.drawable.ic_bar_chart);

    companion object {
        fun getCurrentTopLevelDestination(route: String?): TopLevelDestination? = when (route) {
            MyWalletScreen.route -> MyWalletScreen
            BudgetScreen.route -> BudgetScreen
            ReportScreen.route -> ReportScreen
            else -> null
        }
    }
}
