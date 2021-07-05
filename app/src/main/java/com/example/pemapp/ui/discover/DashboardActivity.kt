package com.example.pemapp.ui.discover

import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pemapp.R
import com.example.pemapp.ui.profile.ProfileViewModel
import com.example.pemapp.services.UserLocation
import com.google.android.gms.location.*

import com.google.android.material.bottomnavigation.BottomNavigationView


class DashboardActivity : AppCompatActivity() {

    val profileViewModel: ProfileViewModel by viewModels()

    //Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback
    private var currentLatitude: Double = 0.0
    private var currentLongitude: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val profileName = intent.getStringExtra("Username")
        val profileEmail = intent.getStringExtra("Email")
        val profilePicture = intent.getStringExtra("Profilepicture")

        //Initialize bottom navigation view
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        val navController = findNavController(R.id.dashboardNavHostFragment)
        bottomNavigationView.setupWithNavController(navController)

        if (profileName != null) {
            profileViewModel.setUsernameDirectly(profileName)
        }
        if (profileEmail != null) {
            profileViewModel.setEmail(profileEmail)
        }

        if (profilePicture != null) {
            profileViewModel.setProfilepicture(profilePicture)
        }

        requestUserLocation()
    }

    private fun requestUserLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if(UserLocation().checkLocationPermission(this.applicationContext)){
            if (UserLocation().isLocationEnabled(this.applicationContext)){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(this) { task ->
                    val location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                        buildLocationCallback()
                        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
                    } else {
                        currentLatitude = location.latitude
                        currentLongitude = location.longitude
                    }
                }
            } else {
                Toast.makeText(this.applicationContext, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                this.startActivity(intent)
            }
        } else{ UserLocation().requestPermissions(this) }
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                currentLatitude = locationResult!!.lastLocation.latitude
                currentLongitude = locationResult!!.lastLocation.longitude

            }
        }
    }

    fun requestNewLocationData() {
        locationRequest = LocationRequest()
        UserLocation().requestNewLocationData(locationRequest)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        requestUserLocation()
    }
}