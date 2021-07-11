package com.example.pemapp.dashboard.appUsage.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.appUsage.model.AppUsageAdapter
import com.example.pemapp.dashboard.appUsage.model.AppUsageModel
import com.example.pemapp.dashboard.appUsage.model.CheckAppsVisible
import com.example.pemapp.onboarding.Categories
import com.example.pemapp.onboarding.ChipAdapter
import kotlinx.android.synthetic.main.fragment_onboarding3.*

class AppUsage : Fragment() {
    private lateinit var appUsageAdapter: AppUsageAdapter
    private lateinit var recyclerView: RecyclerView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_app_usage, container, false)
        val appUsageModel = AppUsageModel()
        //val checkAppsVisible = CheckAppsVisible()
        //checkAppsVisible.startCheck()

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