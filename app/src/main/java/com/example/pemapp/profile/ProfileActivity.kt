package com.example.pemapp.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.discover.DiscoverActivity
import com.example.pemapp.moments.MomentsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_discover.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_discover.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // set 'Profile' selected
        bottom_navigation.selectedItemId = R.id.profile_nav_graph

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.discoverFragment -> {
                    val intent = Intent(this, DiscoverActivity::class.java)
                    startActivity(intent)
                }
                R.id.moments_nav_graph -> {
                    val intent = Intent(this, MomentsActivity::class.java)
                    startActivity(intent)
                }
                R.id.profile_nav_graph -> {
                }
            }
            true
        }
    }
}