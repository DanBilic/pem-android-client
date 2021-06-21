package com.example.pemapp.ui.moments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pemapp.R
import com.example.pemapp.ui.discover.DiscoverActivity
import com.example.pemapp.ui.profile.ProfileActivity
import kotlinx.android.synthetic.main.fragment_discover.*

class MomentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moments)

        // set 'Moments' selected
        bottomNavigation.selectedItemId = R.id.moments_nav_graph

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.discoverFragment -> {
                    val intent = Intent(this, DiscoverActivity::class.java)
                    startActivity(intent)
                }
                R.id.moments_nav_graph -> {
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