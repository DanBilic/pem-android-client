package com.example.pemapp.dashboard.discover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.moments.model.MomentsAdapter
import com.example.pemapp.dashboard.moments.network.DiscoverConnectionFactory
import com.example.pemapp.dashboard.moments.network.DiscoverDataConnection
import com.example.pemapp.dashboard.moments.network.DiscoverNetworkCall
import com.example.pemapp.dashboard.moments.network.MomentsDataConnection
import kotlinx.android.synthetic.main.fragment_discover.view.*


class DiscoverFragment : Fragment() {
    private lateinit var discoverDataConnection: DiscoverDataConnection
    private lateinit var discoverAdapter: DiscoverAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_discover, container, false)

        val discoverNetworkCall = DiscoverNetworkCall()
        val discoverConnectionFactory = DiscoverConnectionFactory(discoverNetworkCall)
        discoverDataConnection = ViewModelProvider(this, discoverConnectionFactory).get(
            DiscoverDataConnection::class.java)

        discoverDataConnection.getMicroTaskData()
        discoverDataConnection.getMicroTaskData.observe(viewLifecycleOwner, { response  ->
            val recyclerView = view.findViewById<RecyclerView>(R.id.discoverrecycler)
            discoverAdapter = DiscoverAdapter(response!!)
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.adapter = discoverAdapter
        })
        return view
    }

}