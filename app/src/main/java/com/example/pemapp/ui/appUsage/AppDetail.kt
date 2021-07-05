package com.example.pemapp.ui.appUsage

data class AppDetail (
    val appName: String,
    val lastTimeUsed: String,
    val firstTimeStamp: String,
    val lastTimeStamp: String,
    val totalTimeInForeground: String,
    val lastTimeVisible: String,
    val totalTimeVisible: String,
    val lastTimeForegroundServiceUsed: String,
    val totalTimeForegroundServiceUsed: String

)