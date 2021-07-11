package com.example.pemapp.notification

import android.R
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.pemapp.dashboard.appUsage.model.AppUsageData


class DailyReceiver : BroadcastReceiver() {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context = con
        }
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val quote: String
        val `when` = System.currentTimeMillis()
        val notificationManager = context
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationIntent = Intent(context, Notification::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        val pendingIntent = PendingIntent.getActivity(
            context, 0,
            notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        // get your quote here
        val notification = Notification(context)
        notification.showNotification(0)
    }

}