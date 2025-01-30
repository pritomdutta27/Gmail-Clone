package com.example.compose.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.model.DrawerMenuData

private val menusDrawerList = listOf(
    DrawerMenuData.Divider,
    DrawerMenuData.AllInboxes,
    DrawerMenuData.Divider,
    DrawerMenuData.Primary,
    DrawerMenuData.Social,
    DrawerMenuData.Promotions,
    DrawerMenuData.HeaderOne,
    DrawerMenuData.Starred,
    DrawerMenuData.Snoozed,
    DrawerMenuData.Important,
    DrawerMenuData.Sent,
    DrawerMenuData.Schedule,
    DrawerMenuData.OutBox,
    DrawerMenuData.Drafts,
    DrawerMenuData.AllMail,
    DrawerMenuData.HeaderTwo,
    DrawerMenuData.Calendar,
    DrawerMenuData.Contacts,
    DrawerMenuData.Divider,
    DrawerMenuData.Settings,
    DrawerMenuData.Help,
)
@Composable
fun GmailDrawerMenu(scrollState: ScrollState) {

    val scrollableModifier = remember(scrollState) {
        Modifier.verticalScroll(scrollState)
    }

    Column(
        modifier = scrollableModifier
            .fillMaxWidth(0.8f)
            .fillMaxHeight()
            .background(Color.White)
            .padding(bottom = 10.dp)

    ) {
        Text(
            "Gmail", color = Color.Red,
            modifier = Modifier
                .fillMaxWidth(.5f)
                .padding(top = 20.dp, start = 20.dp, bottom = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        menusDrawerList.forEach { dataItem ->
            when {
                dataItem.isDivider -> {
                    HorizontalDivider()
                }

                dataItem.isHeader -> {
                    Text(
                        text = dataItem.title ?: "", fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier.padding(bottom = 20.dp, top = 20.dp, start = 20.dp)
                    )
                }

                else -> {
                    MailDrawerItem(dataItem)
                }
            }
        }
    }

}

@Composable
fun MailDrawerItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title ?: "",
            modifier = Modifier.weight(0.5f)
        )
        Text(text = item.title ?: "", modifier = Modifier.weight(2f))
    }
}