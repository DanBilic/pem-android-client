package com.example.pemapp.ui.discover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.ui.moments.MomentsActivity
import com.example.pemapp.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_discover.*
import kotlinx.android.synthetic.main.fragment_discover.*

class DiscoverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)

        // set 'Discover' selected
        bottomNavigation.selectedItemId = R.id.discoverFragment

        var navigationController = discoverNavHostFragment.findNavController()
        bottomNavigation.setupWithNavController(navigationController)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
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