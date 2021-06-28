package com.example.pemapp.ui.moments

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
import com.example.pemapp.network.Connection
import com.example.pemapp.network.ConnectionFactory
import com.example.pemapp.data.repository.Repository
import kotlinx.android.synthetic.main.fragment_moments.view.*

class MomentsFragment : Fragment() {

    private lateinit var viewModel: Connection
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


        val repository = Repository()
        val viewModelFactory = ConnectionFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(Connection::class.java)

        viewModel.getMoments()
        viewModel.getMoments.observe(viewLifecycleOwner, { response  ->
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