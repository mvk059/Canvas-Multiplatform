package com.mvk.common.ui.components

import androidx.compose.ui.Modifier

expect fun CanvasAsyncImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier
)
