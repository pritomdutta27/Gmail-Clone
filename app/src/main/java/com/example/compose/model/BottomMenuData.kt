package com.example.compose.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(val icon: ImageVector, val title: String, val route: String) {
    data object Mail : BottomMenuData(icon = Icons.Outlined.Mail, title = "Mail", route = "Mail")
    data object Meet : BottomMenuData(icon = Icons.Outlined.VideoCall, title = "Meet", route = "Meet")
}