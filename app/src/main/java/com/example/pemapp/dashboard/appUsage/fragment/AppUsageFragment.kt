package com.example.pemapp.dashboard.appUsage.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.appUsage.model.AppUsageAdapter
import com.example.pemapp.dashboard.appUsage.model.AppUsageModel

class AppUsage : Fragment() {
    private lateinit var recyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_app_usage, container, false)
        val appUsageModel = AppUsageModel()

        if (appUsageModel.checkUsageStatePermission()) {
            appUsageModel.getUsageStatsSocialAppsDay()
            appUsageModel.groupList()
            recyclerView = view.findViewById(R.id.appUsage_recycler)
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = AppUsageAdapter(AppUsageModel.appUsageSelected)
        } else {
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }
        return view
    }
}