package com.example.pemapp.ui.appUsage

import android.Manifest
import android.app.AppOpsManager
import android.app.AppOpsManager.OPSTR_GET_USAGE_STATS
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Process.myUid
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.AppOpsManagerCompat
import androidx.fragment.app.Fragment
import com.example.pemapp.R
import kotlinx.android.synthetic.main.fragment_app_usage.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class AppUsage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_app_usage, container, false)
        val appUsageModel = AppUsageModel()

        if(appUsageModel.checkUsageStatePermission()) {
            appUsageModel.showUsageStats()
        } else{
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }

        view.button1.setOnClickListener {
        }
        return view
    }

}