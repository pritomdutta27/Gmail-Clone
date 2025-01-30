package com.example.compose.view

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.compose.model.BottomMenuData

@Composable
fun MailBottomMenu(navController: NavController) {
    val listBottomItem = remember { listOf(BottomMenuData.Mail, BottomMenuData.Meet) }
    // Extract outside to avoid unnecessary recompositions inside NavigationBar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(modifier = Modifier.background(Color.White)) {
        listBottomItem.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = false }
                        launchSingleTop = true
                    }
                },
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) }
            )
        }
    }
}