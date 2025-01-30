package com.example.compose.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.sp

@Composable
fun FabButton(isScrolled: Boolean) {
    if (isScrolled) {
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
