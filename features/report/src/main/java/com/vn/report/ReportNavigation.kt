package com.vn.report

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val REPORT_ROUTE = "report"

fun NavController.navigateToReport() = navigate(REPORT_ROUTE)

fun NavGraphBuilder.reportScreen() {
    composable(REPORT_ROUTE) {
        ReportScreen()
    }
}
