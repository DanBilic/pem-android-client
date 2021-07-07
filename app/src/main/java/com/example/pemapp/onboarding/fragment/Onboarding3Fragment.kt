package com.example.pemapp.onboarding.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pemapp.R
import com.example.pemapp.dashboard.DashboardActivity
import com.example.pemapp.onboarding.Categories
import com.example.pemapp.onboarding.ChipAdapter
import kotlinx.android.synthetic.main.chip_element.view.*
import kotlinx.android.synthetic.main.fragment_onboarding3.*
import kotlinx.android.synthetic.main.fragment_onboarding3.view.*

class Onboarding3Fragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val selectedList: MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding3, container, false)

        view.saveButton.setOnClickListener {
            getSelectedCategories()
            val intent = Intent(getActivity(), DashboardActivity::class.java)
            startActivity(intent)
            //TODO save user input to data base
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewChips)
        recyclerViewChips.apply {
            layoutManager = GridLayoutManager(activity, 3)
            recyclerView.layoutManager = layoutManager
            adapter = ChipAdapter(Categories.categoriesList)
        }
    }

    fun getSelectedCategories() {
        var size = Categories.categoriesList.size - 1
        for (item in 0..size) {
            var chipItem = recyclerView.getChildAt(item).chip
            if (chipItem.isChecked) {
                selectedList.add(chipItem.text as String)
            }
        }
    }
}

