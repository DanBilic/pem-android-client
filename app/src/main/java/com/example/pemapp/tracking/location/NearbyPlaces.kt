package com.example.pemapp.tracking.location

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.pemapp.BuildConfig
import com.google.android.gms.location.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


class NearbyPlaces {

    private var currentLatitude:Double=0.0
    private var currentLongitude:Double=0.0

    private var done:Boolean=false

    //Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    private val typePlaceList = arrayOf("book_store", "cafe", "restaurant", "park", "museum", "movie_theater", "library")

    companion object {
        private const val MY_PERMISSION_CODE: Int = 1000
        private const val MAPS_API_KEY = BuildConfig.MAPS_API_KEY
    }

    fun getUserLocation(context:Context, activity: Activity) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        if(checkLocationPermission(context)){
            if (isLocationEnabled(context)){
                fusedLocationProviderClient.lastLocation.addOnCompleteListener(activity) { task ->
                    val location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData(context)
                        buildLocationCallback()
                        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
                        done = false
                    } else {
                        currentLatitude = location.latitude
                        currentLongitude = location.longitude
                        Toast.makeText(context, "$currentLatitude,$currentLongitude", Toast.LENGTH_LONG).show() //TODO: Delete when not needed anymore
                        done = true
                        getNearbyPlaces()
                    }
                }
            } else {
                Toast.makeText(context, "Please turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                context.startActivity(intent)
                done = false
            }
        } else{
            requestPermissions(activity)
            done = true}
    }

    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                var latitude = locationResult!!.lastLocation.latitude
                var longitude = locationResult!!.lastLocation.longitude
                currentLatitude = latitude
                currentLongitude = longitude
            }
        }
    }

    private fun checkLocationPermission(context: Context): Boolean {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun isLocationEnabled(context: Context): Boolean {
        val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun requestPermissions(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
            MY_PERMISSION_CODE
        )
    }

    private fun requestNewLocationData(context: Context) {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 0
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray, context: Context, activity: Activity) {
        if (requestCode == MY_PERMISSION_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getUserLocation(context, activity)
            }
        }
    }

    fun getNearbyPlaces(){
        if(done){
            Log.d("----------WORKS----", "IT WORKS HERE")
            val url = getURL(currentLongitude.toString(), currentLatitude.toString(), typePlaceList[2])
            val request = Request.Builder().url(url).build()
            //val response = OkHttpClient().newCall(request).execute().body!!.string()
            val response = OkHttpClient().newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    call.cancel()
                }
                override fun onResponse(call: Call, response: Response) {
                    val currentPlace = response.body!!.string()
                    val jsonObject = JSONObject(currentPlace)
                    Log.d("----------RESPONSE----", jsonObject.toString())
                }
            })
        }

    }

    private fun getURL(latitude: String, longitude: String, s: String): String {
        val googlePlaceUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"+
                "?location=" + latitude + "," + longitude +
                "&radius=5000" +
                "&types=" + s +
                "&sensor=true" +
                "&key=" + MAPS_API_KEY;

        return googlePlaceUrl
    }

}