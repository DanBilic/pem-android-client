package com.example.pemapp.login

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.pemapp.R
import com.example.pemapp.dashboard.appUsage.model.ListeningToActivityCallbacks
import com.example.pemapp.notification.DailyReceiver

class LoginActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerActivityLifecycleCallbacks(ListeningToActivityCallbacks())
        DailyReceiver.setContext(this)

        setContentView(R.layout.activity_login)
    }
}