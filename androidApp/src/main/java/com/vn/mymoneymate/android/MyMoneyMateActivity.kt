package com.vn.mymoneymate.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

internal class MyMoneyMateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoneyMateApp()
        }
    }
}
