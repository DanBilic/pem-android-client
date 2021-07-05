package com.example.pemapp.dashboard.moments.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.moments.model.MomentsAdapter
import com.example.pemapp.dashboard.moments.network.MomentsConnectionFactory
import com.example.pemapp.dashboard.moments.network.MomentsDataConnection
import com.example.pemapp.dashboard.moments.network.MomentsNetworkCall
import kotlinx.android.synthetic.main.fragment_moments.view.*

class MomentsFragment : Fragment() {

    private lateinit var momentsDataConnection: MomentsDataConnection
    private lateinit var momentsAdapter: MomentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_moments, container, false)

        view.composeButton.setOnClickListener {
            findNavController().navigate(R.id.action_momentsFragment_to_composeMomentsFragment)
        }
        val momentsNetworkCall = MomentsNetworkCall()
        val momentsConnectionFactory = MomentsConnectionFactory(momentsNetworkCall)
        momentsDataConnection = ViewModelProvider(this, momentsConnectionFactory).get(
            MomentsDataConnection::class.java)

        momentsDataConnection.getMoments()
        momentsDataConnection.getMoments.observe(viewLifecycleOwner, { response  ->
            val recyclerView = view.findViewById<RecyclerView>(R.id.moments_recycler)
            momentsAdapter = MomentsAdapter(response!!)
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.adapter = momentsAdapter
        })
        return view
    }
}