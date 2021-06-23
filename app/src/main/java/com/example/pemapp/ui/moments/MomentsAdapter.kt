package com.example.pemapp.ui.moments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.data.model.MomentModel


class MomentsAdapter(private val dataSet: List<MomentModel>) :
    RecyclerView.Adapter<MomentsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var username: TextView = view.findViewById(R.id.usernameView)
        var text: TextView = view.findViewById(R.id.descriptionTextView)
        var posttime: TextView = view.findViewById(R.id.posttimeView)
        var profilepicture: ImageView = view.findViewById(R.id.profilepicture)
        //var picture: ImageView = view.findViewById(R.id.year)
    }


    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_moments_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val user = dataSet[position]
        holder.username.text = user.username
        holder.text.text = user.text
        holder.posttime.text = user.posttime
        //holder.profilepicture.setImageBitmap() = user.profilepicture
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
