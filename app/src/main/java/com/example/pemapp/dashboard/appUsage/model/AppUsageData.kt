package com.example.pemapp.dashboard.appUsage.model

data class AppUsageData (
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