package com.example.pemapp.dashboard.appUsage.model

import android.Manifest
import android.app.AppOpsManager
import android.app.AppOpsManager.OPSTR_GET_USAGE_STATS
import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Process.myUid
import androidx.annotation.RequiresApi
import androidx.core.app.AppOpsManagerCompat.MODE_ALLOWED
import com.example.pemapp.dashboard.appUsage.fragment.AppUsage
import com.example.pemapp.user.model.UserData
import java.text.SimpleDateFormat
import java.util.*


class AppUsageModel {

    companion object {

        private lateinit var context: Context
        private val appUsageList: MutableList<AppUsageData> = mutableListOf()

        fun setContext(con: Context) {
            context = con
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

    @RequiresApi(Build.VERSION_CODES.M)
    fun getUsageStatsSocialAppsDay() {
        var usageStatsManager: UsageStatsManager =
            context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
        var cal: Calendar = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_MONTH, -1)
        var queryUsageStats: List<UsageStats> = usageStatsManager.queryUsageStats(
            UsageStatsManager.INTERVAL_DAILY,
            cal.timeInMillis,
            System.currentTimeMillis()
        )
        for (i in queryUsageStats.indices) {
            for (apps in SocialApps.socialAppsList) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    //if (queryUsageStats[i].packageName.contains(apps)) {
                        var appUsageD = AppUsageData(
                            queryUsageStats[i].packageName,
                            convertDateTime(queryUsageStats[i].lastTimeUsed),
                            queryUsageStats[i].firstTimeStamp,
                            queryUsageStats[i].lastTimeStamp,
                            convertTime(queryUsageStats[i].totalTimeInForeground),
                            convertDateTime(queryUsageStats[i].lastTimeVisible),
                            convertTime(queryUsageStats[i].totalTimeVisible),
                            convertDateTime(queryUsageStats[i].lastTimeForegroundServiceUsed),
                            convertTime(queryUsageStats[i].totalTimeForegroundServiceUsed)
                        )
                        appUsageList.add(appUsageD)
                   // }
                }
            }
        }
        var isappActive = usageStatsManager.isAppInactive("com.spotify.music")
        println("IS ACTIVE?? " + isappActive)

        for (element in appUsageList) {
            //println("apps : " + element.appName)
            for (apps in SocialApps.socialAppsList) {
                //println("element " + element.appName + " apps " + apps)
                if (element.appName.contains(apps)) {
                    println("app Name : " + element.appName)
                    println("last time used : " + element.lastTimeUsed)
                    println("first time stamp : " + element.firstTimeStamp)
                    println("last time stamp : " + element.lastTimeStamp)
                    println("total timein foreground : " + element.totalTimeInForeground)
                    println("last time visible : " + element.lastTimeVisible)
                    println("total time visible : " + element.totalTimeVisible)
                    println("last time foreground service : " + element.lastTimeForegroundServiceUsed)
                    println("total time foreground service : " + element.totalTimeForegroundServiceUsed)

                }
            }


        }
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
