package com.example.pemapp.login

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkRequest
import com.example.pemapp.R
import com.example.pemapp.dashboard.appUsage.model.ListeningToActivityCallbacks
import com.example.pemapp.dashboard.appUsage.model.UploadWorker
import com.example.pemapp.login.network.LoginDataConnection
import com.example.pemapp.notification.DailyReceiver
import com.example.pemapp.notification.Notification

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginDataConnection
    private lateinit var email: String
    private lateinit var password: String

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerActivityLifecycleCallbacks(ListeningToActivityCallbacks())
        DailyReceiver.setContext(this)

        setContentView(R.layout.activity_login)


    }


}