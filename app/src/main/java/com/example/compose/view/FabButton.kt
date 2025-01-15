package com.example.compose.view

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun FabButton(lazyListState: LazyListState) {
    val showExtendedFab by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex > 0 || lazyListState.firstVisibleItemScrollOffset > 100
        }
    }

    if (showExtendedFab) {
        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Outlined.Edit, "Extended floating action button.") },
            text = { Text(text = "Compose", fontSize = 15.sp) },
        )
    } else {
        FloatingActionButton(
            onClick = {},
            containerColor = MaterialTheme.colorScheme.surface
        ) {
            Icon(Icons.Outlined.Edit, "Edit.")
        }
    }
}
