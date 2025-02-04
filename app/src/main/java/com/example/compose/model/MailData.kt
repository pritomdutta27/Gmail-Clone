package com.example.compose.model

import androidx.compose.runtime.Immutable

@Immutable
data class MailData(
    val mailId: Int,
    val userName: String,
    val subject: String,
    val body: String,
    val timeStamp: String = ""
)
