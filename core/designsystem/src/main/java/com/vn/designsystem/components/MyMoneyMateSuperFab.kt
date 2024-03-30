package com.vn.designsystem.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun MyMoneyMateSuperFab(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick, shape = CircleShape) {
        Icon(Icons.Filled.Add, contentDescription = "Floating button")
    }
}
