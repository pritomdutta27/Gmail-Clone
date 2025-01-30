package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.datasource.mailDataList
import com.example.compose.model.BottomMenuData
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.view.FabButton
import com.example.compose.view.GmailDrawerMenu
import com.example.compose.view.HomeAppBar
import com.example.compose.view.MailBottomMenu
import com.example.compose.view.MailItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ComposeTheme {
                GmailApp()
            }
        }
    }
}


@Composable
fun GmailApp() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    val isScrolled by remember { derivedStateOf { lazyListState.firstVisibleItemIndex > 0 } }
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    val openDialogState = remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        modifier = Modifier.background(Color.White),
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet { GmailDrawerMenu(scrollState) }
        },
    ) {
        Scaffold(
            topBar = {
                HomeAppBar(
                    onDrawerToggle = { coroutineScope.launch { drawerState.open() } },
                    openDialogState.value,
                    onDialogChange = { openDialogState.value = it }
                )
            },
            bottomBar = {
                MailBottomMenu(navController)
            },
            floatingActionButton = { FabButton(isScrolled = isScrolled)  },
            containerColor = Color.White,
        )
        { innerPadding ->

            NavHost(navController = navController, startDestination = BottomMenuData.Mail.route) {
                composable(BottomMenuData.Mail.route) {
                    MailSection(
                        modifier = Modifier.padding(innerPadding), lazyListState
                    )
                }
                composable(BottomMenuData.Meet.route) {
                    MeetSection(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }


        }
    }
}

@Composable
fun MailSection(modifier: Modifier, scrollState: LazyListState) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        state = scrollState
    ) {
        items(mailDataList, key = { it.mailId }) { data ->
            MailItem(data)
        }
    }
}

@Composable
fun MeetSection(modifier: Modifier) {
    Text("Meet", modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        GmailApp()
    }
}