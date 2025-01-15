package com.example.compose.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.compose.R

@Composable
fun AccountDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false }) {
        AccountDialogUI(Modifier, openDialog)
    }
}

@Composable
fun AccountDialogUI(modifier: Modifier, openDialog: MutableState<Boolean>) {
    Card {
        Column(
            modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Row(modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.ic_google_),
                    contentDescription = "",
                    modifier = modifier
                        .size(50.dp)
                        .weight(2.0f)
                )

                IconButton(onClick = { openDialog.value = false }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "",
                        modifier.size(20.dp)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentHeight() // Ensures the row's height wraps its content
                    .wrapContentWidth(), // Ensures the row's width wraps its content
                verticalAlignment = Alignment.CenterVertically // Aligns items vertically
            ) {

                Card(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(40.dp)
                        .clip(CircleShape),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.LightGray,
                    )
                ) {
                    Box(
                        contentAlignment = Alignment.Center, // Centers the content inside the Box
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight() // Ensures the Box fills the Card's dimensions
                    ) {
                        Image(
                            painter = painterResource(R.drawable.boy_photo),
                            contentDescription = "",
                            modifier
                                .size(50.dp)
                                .clip(CircleShape)
                        )
                    }
                }

                Column(Modifier.weight(2.0f)) {
                    Text(
                        text = "Pritom Dutta",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(
                        text = "pritom00019@gmail.com",
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.requiredWidth(150.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, Color.Gray)
                ) {
                    Text(
                        text = "Google Account",
                        modifier = modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier.width(10.dp))
            }
            HorizontalDivider(modifier.padding(top = 16.dp))
        }
    }
}