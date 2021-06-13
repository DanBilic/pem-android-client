package com.example.pemapp.discover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.moments.MomentsActivity
import com.example.pemapp.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_discover.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_discover.*

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        // set 'Discover' selected
        bottom_navigation.selectedItemId = R.id.discoverFragment

        var navigationController = discover_navHostFragment.findNavController()
        bottom_navigation.setupWithNavController(navigationController)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.discoverFragment -> {
                }
                R.id.moments_nav_graph -> {
                    val intent = Intent(this, MomentsActivity::class.java)
                    startActivity(intent)
                }
                R.id.profile_nav_graph -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }

    }
}