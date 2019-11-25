package com.example.passenger.ui

import java.text.SimpleDateFormat
import java.util.*

private val dataFormat = SimpleDateFormat("EEEE, HH:mm", Locale.US)

fun Date.formatForWeather(): String {
    return dataFormat.format(this)
}


fun Float.formatTemperature(): String {
    return "%.1f°C".format(this)
}