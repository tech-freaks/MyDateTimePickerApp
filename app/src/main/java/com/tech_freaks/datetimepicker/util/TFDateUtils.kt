package com.tech_freaks.datetimepicker.util

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object TFDateUtils {

    fun getCurrentDateString(format: String = "MM/dd/yyyy"): String {
        var formatter = DateTimeFormatter.ofPattern(format)
        return LocalDate.now().format(formatter)
    }

    fun convertMillisToLocalDate(millis: Long) : LocalDate {
        return LocalDate.ofEpochDay(Duration.ofMillis(millis).toDays());
    }

    fun convertMillisToDateString(millis: Long, format: String = "MM/dd/yyyy"): String {
        var formatter = DateTimeFormatter.ofPattern(format)
        return convertMillisToLocalDate(millis).format(formatter)
    }

    fun getCurrentTimeString(format: String = "hh:mm a"): String {
        var formatter = DateTimeFormatter.ofPattern(format)
        return LocalTime.now().format(formatter)
    }

    fun getTimeString(hour: Int, min: Int, format: String = "hh:mm a") : String {
        var formatter = DateTimeFormatter.ofPattern(format)
        var localTime = LocalTime.of(hour, min)
        return localTime.format(formatter)
    }

    fun getLocalDataTimeFromString(dateTime: String, format: String): LocalDateTime {
        var formatter = DateTimeFormatter.ofPattern(format)
        return LocalDateTime.parse(dateTime, formatter)
    }
}