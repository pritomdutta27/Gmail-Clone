package com.example.compose.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.MailData


@Composable
fun MailItem(mailData: MailData) {
    val firstLetter = remember(mailData.userName) { mailData.userName[0].toString() }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight()
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .clip(CircleShape),
            colors = CardDefaults.cardColors(containerColor = Color.Gray)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = firstLetter,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }

        Column(Modifier.weight(2.0f)) {
            Text(
                text = mailData.userName,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = mailData.subject,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = mailData.body,
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

        Column(Modifier.weight(0.5f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = mailData.timeStamp,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
            IconButton(onClick = { /* Handle star click */ }) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "Star Email")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreViewItem() {
    MailItem(
        MailData(
            242,
            "Charlie",
            "Project Deadlinessadas",
            "Your input is valuable to us.",
            "23:00"
        )
    )
}