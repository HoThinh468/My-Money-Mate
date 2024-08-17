package com.vn.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vn.designsystem.dimension.mediumSpacing
import com.vn.designsystem.dimension.smallSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(
    @StringRes titleRes: Int? = null,
    navigationIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = MaterialTheme.colorScheme.onBackground,
    actionComposable: @Composable () -> Unit = {},
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.padding(end = smallSpacing),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            titleContentColor = contentColor
        ),
        title = {
            if (titleRes != null) {
                Text(
                    text = stringResource(id = titleRes),
                    style = MaterialTheme.typography.titleSmall
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Small app bar navigation icon"
                )
            }
        },
        actions = {
            actionComposable()
        }
    )
}

@Preview
@Composable
fun SmallTopAppBarPreview() {
    SmallTopAppBar {
        // Do nothing
    }
}
