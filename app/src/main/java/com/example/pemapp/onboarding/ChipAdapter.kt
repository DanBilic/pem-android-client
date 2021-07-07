package com.example.pemapp.onboarding

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.moments.model.MomentsAdapter
import com.example.pemapp.dashboard.moments.model.MomentsData
import com.google.android.material.chip.Chip

class ChipAdapter(private val dataSet: List<String>) :
    RecyclerView.Adapter<ChipAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var chip: Chip = view.findViewById(R.id.chip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chip_element, parent, false)
        return ChipAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chip.text = dataSet[position]
        println(dataSet[position])
        println("size" + dataSet.size)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}