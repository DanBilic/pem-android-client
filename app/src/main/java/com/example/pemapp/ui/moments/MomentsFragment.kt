package com.example.pemapp.ui.moments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pemapp.R
import com.example.pemapp.data.MainViewModel
import com.example.pemapp.data.MainViewModelFactory
import com.example.pemapp.data.repository.Repository
import kotlinx.android.synthetic.main.fragment_discover.view.*
import java.util.Observer

class MomentsFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hide titleBar
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_moments, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getMoments()
        viewModel.getMoments.observe(viewLifecycleOwner,  { response ->
            println(response)
        })


        return view
    }
}