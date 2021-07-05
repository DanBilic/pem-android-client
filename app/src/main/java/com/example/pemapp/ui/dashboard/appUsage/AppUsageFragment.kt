package com.example.pemapp.ui.dashboard.appUsage

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pemapp.R
import com.example.pemapp.ui.dashboard.moments.MomentsAdapter

class AppUsage : Fragment() {
    private lateinit var appUsageAdapter: AppUsageAdapter

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


        return view
    }

}