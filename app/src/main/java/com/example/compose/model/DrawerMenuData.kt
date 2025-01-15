package com.example.compose.model


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Drafts
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Snooze
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon: ImageVector? = null, val title: String? = "",
    val isDivider: Boolean = false, val isHeader: Boolean = false
) {
    data object AllInboxes : DrawerMenuData(
        icon = Icons.Outlined.AllInbox,
        title = "All Indexes"
    )

    data object Primary : DrawerMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Primary"
    )

    data object Social : DrawerMenuData(
        icon = Icons.Outlined.Person,
        title = "Social"
    )

    data object Promotions : DrawerMenuData(
        icon = Icons.Outlined.Tag,
        title = "Promotions"
    )

    data object Starred : DrawerMenuData(
        icon = Icons.Outlined.StarOutline,
        title = "Starred"
    )

    data object Snoozed : DrawerMenuData(
        icon = Icons.Outlined.Snooze,
        title = "Snoozed"
    )

    data object Important : DrawerMenuData(
        icon = Icons.Outlined.Label,
        title = "Important"
    )

    data object Sent : DrawerMenuData(
        icon = Icons.Outlined.Send,
        title = "Sent"
    )

    data object Schedule : DrawerMenuData(
        icon = Icons.Outlined.Schedule,
        title = "Schedule"
    )

    data object Inbox : DrawerMenuData(
        icon = Icons.Outlined.Inbox,
        title = "Inbox"
    )

    data object OutBox : DrawerMenuData(
        icon = Icons.Outlined.Outbox,
        title = "Outbox"
    )

    data object Drafts : DrawerMenuData(
        icon = Icons.Outlined.Drafts,
        title = "Drafts"
    )

    data object AllMail : DrawerMenuData(
        icon = Icons.Outlined.Mail,
        title = "All Mail"
    )

    data object Calendar : DrawerMenuData(
        icon = Icons.Outlined.CalendarToday,
        title = "Calendar"
    )

    data object Contacts : DrawerMenuData(
        icon = Icons.Outlined.Contacts,
        title = "Contacts"
    )


    data object Settings : DrawerMenuData(
        icon = Icons.Outlined.Settings,
        title = "Settings"
    )

    data object Help : DrawerMenuData(
        icon = Icons.Outlined.Help,
        title = "Help & FeedBack"
    )

    data object Divider : DrawerMenuData(
        isDivider = true
    )

    data object HeaderOne : DrawerMenuData(
        isHeader = true,
        title = "ALL LABELS"
    )

    data object HeaderTwo : DrawerMenuData(
        isHeader = true,
        title = "GOOGLE APPS"
    )

}