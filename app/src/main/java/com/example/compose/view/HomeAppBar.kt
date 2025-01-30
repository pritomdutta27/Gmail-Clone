package com.example.compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose.R

@Composable
fun HomeAppBar(onDrawerToggle: () -> Unit, openDialog: Boolean, onDialogChange: (Boolean)->Unit) {
    Box(modifier = Modifier.padding(10.dp)) {
        Card(
            modifier = Modifier.requiredHeight(50.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = {onDrawerToggle()}) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }

                Text("Search in emails..", modifier = Modifier.weight(2.0f))

                Image(
                    painter = painterResource(R.drawable.icon_gmail),
                    contentDescription = "App Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(top = 5.dp, bottom = 5.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .clickable { onDialogChange(true) }
                )

                if (openDialog){
                    AccountDialog(onDialogChange)
                }
            }
        }
    }


}

//@Preview(showBackground = true)
//@Composable
//fun HomeBarPreview() {
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val coroutineScope = rememberCoroutineScope()
//    HomeAppBar(drawerState = drawerState, coroutineScope = coroutineScope, remember { mutableStateOf(false) })
//}