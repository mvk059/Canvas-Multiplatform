package com.mvk.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.mvk.common.navigation.Screens

@Composable
fun App(
    onListItemClick: (Screens) -> Unit,
) {

    Staggered(
        modifier = Modifier.fillMaxSize(),
        onListItemClick = onListItemClick
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Staggered(
    modifier: Modifier = Modifier,
    onListItemClick: (Screens) -> Unit,
) {
    LazyVerticalStaggeredGrid(
        modifier = modifier,
        columns = StaggeredGridCells.Fixed(2),
        content = {

            items(Screens.values().size) { position ->

                Text(
                    modifier = Modifier
                        .border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color.Cyan
                            ),
                            shape = RectangleShape,
                        )
                        .padding(8.dp)
                        .clickable { onListItemClick(Screens.values()[position]) },
                    text = "${Screens.values()[position]}"
                )
            }
        }
    )
}
