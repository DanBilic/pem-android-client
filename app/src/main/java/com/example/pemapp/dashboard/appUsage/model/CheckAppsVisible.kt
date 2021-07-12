package com.example.pemapp.dashboard.appUsage.model

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import androidx.core.content.ContextCompat.getSystemService

class CheckAppsVisible {
    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context = con
        }
    }

    fun startCheck(){
       var activityManager: ActivityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        //var activityManager: ActivityManager = AppService.thi
        var appProcess: List <RunningAppProcessInfo> = activityManager.runningAppProcesses

        for (element in appProcess) {
            println("apps : " + element.processName)
        }

    }
}