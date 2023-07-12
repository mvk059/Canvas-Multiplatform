package com.mvk.common.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    showNavigationIcon: Boolean = true,
    onNavigationIconClick: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = { Text(title) },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(
                    onClick = { onNavigationIconClick() }
                ) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
    )
}
