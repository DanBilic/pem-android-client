package com.example.pemapp.dashboard.appUsage.model

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ListeningToActivityCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityCreated")
    }

    override fun onActivityStarted(activity: Activity) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityStarted")
    }

    override fun onActivityResumed(activity: Activity) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityResumed")
    }

    override fun onActivityPaused(activity: Activity) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityPaused")
    }

    override fun onActivityStopped(activity: Activity) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityStopped")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivitySaveInstanceState")
    }

    override fun onActivityDestroyed(activity: Activity) {
        println("XXXXXXXXXXXXXXX ${activity.localClassName} is onActivityDestroyed")
    }

}