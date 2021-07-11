package com.example.pemapp.dashboard.appUsage.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import org.w3c.dom.Text

class AppUsageAdapter(private val dataSet: List<AppUsageData>) :
    RecyclerView.Adapter<AppUsageAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val appName: TextView = view.findViewById(R.id.appNameTextView)
        val lastTimeUsed: TextView = view.findViewById(R.id.lastTimeUsed)
        val totalTimeVisible: TextView = view.findViewById(R.id.totalTimeVisible)
        val imageView: ImageView = view.findViewById(R.id.appIcon)
        val countUsage: TextView = view.findViewById(R.id.countUsage)
    }


    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_usage_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val appUsage = dataSet[position]
        holder.appName.text = appUsage.appName
        holder.lastTimeUsed.text = appUsage.lastTimeUsed
        holder.totalTimeVisible.text = appUsage.totalTimeVisible
        holder.imageView.setImageResource(appUsage.picture)
        holder.countUsage.text = appUsage.countUsage.toString()
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}