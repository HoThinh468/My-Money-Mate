package com.vn.utility

import java.text.SimpleDateFormat
import java.util.Locale

object DateTimeFormatter {
    private const val DATE_FORMAT = "dd MMM, yyyy"
    private const val TIME_FORMAT = "HH:mm"

    fun formatDate(date: Long): String {
        val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return simpleDateFormat.format(date)

    }

    fun formatTime(time: Long): String {
        val simpleDateFormat = SimpleDateFormat(TIME_FORMAT, Locale.getDefault())
        return simpleDateFormat.format(time)
    }
}