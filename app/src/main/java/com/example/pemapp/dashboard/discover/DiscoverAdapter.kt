package com.example.pemapp.dashboard.discover

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R


class DiscoverAdapter (private val dataSet: List<MicroTaskData>) :
    RecyclerView.Adapter<DiscoverAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var taskTitle: TextView = view.findViewById(R.id.taskTitle)
        var taskDescription: TextView = view.findViewById(R.id.taskDescription)
        var taskCategory: TextView = view.findViewById(R.id.category)
        var taskPicture: ImageView = view.findViewById(R.id.typepicture)

    }


    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_layout, parent, false)
        println(dataSet)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val microtasks = dataSet[position]
        holder.taskTitle.text = microtasks.Title
        holder.taskDescription.text = microtasks.Description
        holder.taskCategory.text = microtasks.Category
        println(microtasks.Type)
        if (microtasks.Type == "Event") {
            holder.taskPicture.setImageResource(R.drawable.event)
        }

       /* if (user.picture != "") {
            holder.pictureView.setImageBitmap(decode(user.picture))
        }
        if (user.profilepicture != "") {
            holder.profilepicture.setImageBitmap(decode(user.profilepicture))
        }*/
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
