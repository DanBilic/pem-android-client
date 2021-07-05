package com.example.pemapp.ui.appUsage

import android.Manifest
import android.app.AppOpsManager
import android.app.AppOpsManager.OPSTR_GET_USAGE_STATS
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Process.myUid
import androidx.core.app.AppOpsManagerCompat.MODE_ALLOWED
import java.text.SimpleDateFormat
import java.util.*


class AppUsageModel {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
    }

    fun checkUsageStatePermission(): Boolean {
        val appOps = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
        val mode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            appOps.unsafeCheckOpNoThrow(OPSTR_GET_USAGE_STATS, myUid(), context.getPackageName())
        } else {
            TODO("VERSION.SDK_INT < Q")
        }
        return if (mode == AppOpsManager.MODE_DEFAULT) {
            context.checkCallingOrSelfPermission(Manifest.permission.PACKAGE_USAGE_STATS) == PackageManager.PERMISSION_GRANTED
        } else {
            mode == MODE_ALLOWED
        }
    }

    fun showUsageStats(){
        var usageStatsManager: UsageStatsManager = context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        var cal: Calendar = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_MONTH, -1)
        var queryUsageStats : List <UsageStats> = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, cal.timeInMillis, System.currentTimeMillis())
        var stats_data = ""
        for (i in queryUsageStats.indices) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                stats_data = stats_data + "Package Name : " + queryUsageStats[i].packageName + "\n" +
                        "Last Time Used : "+ convertDateTime(queryUsageStats[i].lastTimeUsed) + "\n" +
                        "Describe Contents: "+ queryUsageStats[i].describeContents() + "\n" +
                        "First Time Stamp : "+ queryUsageStats[i].firstTimeStamp + "\n" +
                        "Last Time Stamp : "+ queryUsageStats[i].lastTimeStamp + "\n" +
                        "Total Time in Foreground : "+ convertTime(queryUsageStats[i].totalTimeInForeground) + "\n"+
                        "Last Time Visible : " + convertDateTime(queryUsageStats[i].lastTimeVisible)  + "\n" +
                        "Total Time visible: " + convertTime(queryUsageStats[i].totalTimeVisible) + "\n" +
                        "Last Time Foreground Service Used : " + convertDateTime(queryUsageStats[i].lastTimeForegroundServiceUsed) + "\n" +
                        "Total Time Foreground Service Used : " + convertTime(queryUsageStats[i].totalTimeForegroundServiceUsed) + "\n"
            }
        }

        print(stats_data)
    }

    private fun convertDateTime(lastTimeUsed: Long): String {
        var date = Date(lastTimeUsed)
        var format = SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH)
        return format.format(date)
    }

    private fun convertTime(lastTimeUsed: Long): String {
        var date = Date(lastTimeUsed)
        var format = SimpleDateFormat("hh:mm", Locale.ENGLISH)
        return format.format(date)
    }
}