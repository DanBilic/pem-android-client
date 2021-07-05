package com.example.pemapp.dashboard.appUsage.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R

class AppUsageAdapter(private val dataSet: List<AppUsageData>) :
    RecyclerView.Adapter<AppUsageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appName = view.findViewById<TextView>(R.id.appNameTextView)
        val lastTimeUsed = view.findViewById<TextView>(R.id.lastTimeUsed)
//        val firstTimeStamp = view.findViewById<TextView>(R.id.appName)
//        val lastTimeStamp = view.findViewById<TextView>(R.id.appName)
        val totalTimeInForeground = view.findViewById<TextView>(R.id.totalTimeForeground)
//        val lastTimeVisible = view.findViewById<TextView>(R.id.appName)
        val totalTimeVisible = view.findViewById<TextView>(R.id.totalTimeVisible)
//        val lastTimeForegroundServiceUsed = view.findViewById<TextView>(R.id.appName)
//        val totalTimeForegroundServiceUsed = view.findViewById<TextView>(R.id.appName)
    }


    @NonNull
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.app_usage_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val appUsage = dataSet[position]
        viewHolder.appName.text = appUsage.appName
        viewHolder.lastTimeUsed.text = appUsage.lastTimeUsed
        viewHolder.totalTimeInForeground.text = appUsage.totalTimeInForeground
        viewHolder.totalTimeVisible.text = appUsage.totalTimeVisible
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}