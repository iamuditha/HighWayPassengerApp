package com.example.passenger.ui

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.passenger.R
import com.example.passenger.TrackerActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private val TAG = MapsActivity::class.java.simpleName
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?) {


        Log.i("checking", "called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        buttonSeatBook.setOnClickListener {
            startActivity(Intent(this, TrackerActivity::class.java))
        }

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            listOf(
                "Select Route",
                "Matara -> Makumbura",
                "Makumbura -> Matara",
                "Matara -> Colombo",
                "Colombo -> Matara",
                "Matara -> Kaduwela",
                "Kaduwela -> Matara"
            )
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        getDirections.setOnClickListener {

            displayRoute(spinner.selectedItem.toString())

        }

        clear.setOnClickListener {
            recreate()
        }
        val name = spinner.selectedItem.toString()
        Log.i("check", name)

    }

    fun displayRoute(route: String) {
        if (route == "Matara -> Makumbura" || route == "Makumbura -> Matara") {
            map.addPolyline(
                PolylineOptions()
                    .clickable(true)
                    .add(
                        LatLng(5.943874, 80.549228),
                        LatLng(5.948335, 80.547402),
                        LatLng(5.948848, 80.538625),
                        LatLng(5.948051, 80.534995),
                        LatLng(5.953046, 80.534828),
                        LatLng(5.957571, 80.530855),
                        LatLng(5.959941, 80.52875),
                        LatLng(5.963458, 80.522708),
                        LatLng(5.967523, 80.520309),
                        LatLng(5.976295, 80.518382),
                        LatLng(5.981058, 80.508369),
                        LatLng(6.023189, 80.431166),
                        LatLng(6.036988, 80.362511),
                        LatLng(6.071709, 80.263058),
                        LatLng(6.184991, 80.192868),
                        LatLng(6.275869, 80.135757),
                        LatLng(6.455531, 80.087069),
                        LatLng(6.545657, 80.042789),
                        LatLng(6.719772, 79.999851),
                        LatLng(6.787060, 79.981023),
                        LatLng(6.840477, 79.981174),
                        LatLng(6.840443, 79.975957)
                    )
            )

            map.addMarker(MarkerOptions().position(LatLng(5.943874, 80.549228)))
            map.addMarker(MarkerOptions().position(LatLng(6.840443, 79.975957)))
        }

        if (route == "Matara -> Colombo" || route == "Colombo -> Matara") {
            map.addPolyline(
                PolylineOptions()
                    .clickable(true)
                    .add(
                        LatLng(5.943874, 80.549228),
                        LatLng(5.948335, 80.547402),
                        LatLng(5.948848, 80.538625),
                        LatLng(5.948051, 80.534995),
                        LatLng(5.953046, 80.534828),
                        LatLng(5.957571, 80.530855),
                        LatLng(5.959941, 80.52875),
                        LatLng(5.963458, 80.522708),
                        LatLng(5.967523, 80.520309),
                        LatLng(5.976295, 80.518382),
                        LatLng(5.981058, 80.508369),
                        LatLng(6.023189, 80.431166),
                        LatLng(6.036988, 80.362511),
                        LatLng(6.071709, 80.263058),
                        LatLng(6.184991, 80.192868),
                        LatLng(6.275869, 80.135757),
                        LatLng(6.455531, 80.087069),
                        LatLng(6.545657, 80.042789),
                        LatLng(6.719772, 79.999851),
                        LatLng(6.787060, 79.981023),
                        LatLng(6.840477, 79.981174),
                        LatLng(6.840443, 79.975957),
                        LatLng(6.841528, 79.964374),
                        LatLng(6.846354, 79.948473),
                        LatLng(6.849155, 79.924269),
                        LatLng(6.852681, 79.915836),
                        LatLng(6.857762, 79.908584),
                        LatLng(6.862950, 79.901417),
                        LatLng(6.870076, 79.887737),
                        LatLng(6.878693, 79.874144),
                        LatLng(6.883017, 79.868844),
                        LatLng(6.890069, 79.863834),
                        LatLng(6.899389, 79.859896),
                        LatLng(6.903564, 79.858491),
                        LatLng(6.914221, 79.858797),
                        LatLng(6.916553, 79.863057),
                        LatLng(6.927385, 79.849667),
                        LatLng(6.928845, 79.848594),
                        LatLng(6.932562, 79.846287),
                        LatLng(6.934127, 79.849789),
                        LatLng(6.934132, 79.850111)
                    )
            )
            map.addMarker(MarkerOptions().position(LatLng(5.943874, 80.549228)))
            map.addMarker(MarkerOptions().position(LatLng(6.934132, 79.850111)))
        }

        if (route == "Matara -> Kaduwela" || route == "Kaduwela -> Matara") {
            map.addPolyline(
                PolylineOptions()
                    .clickable(true)
                    .add(
                        LatLng(5.943874, 80.549228),
                        LatLng(5.948335, 80.547402),
                        LatLng(5.948848, 80.538625),
                        LatLng(5.948051, 80.534995),
                        LatLng(5.953046, 80.534828),
                        LatLng(5.957571, 80.530855),
                        LatLng(5.959941, 80.52875),
                        LatLng(5.963458, 80.522708),
                        LatLng(5.967523, 80.520309),
                        LatLng(5.976295, 80.518382),
                        LatLng(5.981058, 80.508369),
                        LatLng(6.023189, 80.431166),
                        LatLng(6.036988, 80.362511),
                        LatLng(6.071709, 80.263058),
                        LatLng(6.184991, 80.192868),
                        LatLng(6.275869, 80.135757),
                        LatLng(6.455531, 80.087069),
                        LatLng(6.545657, 80.042789),
                        LatLng(6.719772, 79.999851),
                        LatLng(6.787060, 79.981023),
                        LatLng(6.842378, 79.979901),
                        LatLng(6.884510, 79.976553),
                        LatLng(6.922715, 79.979954),
                        LatLng(6.934516, 79.971451),
                        LatLng(6.936420, 79.983381)
                    )
            )

            map.addMarker(MarkerOptions().position(LatLng(5.943874, 80.549228)))
            map.addMarker(MarkerOptions().position(LatLng(6.936420, 79.983381)))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val latitude = 6.9271
        val longitude = 79.8612
        val zoomLevel = 10f
        val overlaySize = 100f

        val homeLatLng = LatLng(latitude, longitude)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))

        val googleOverlay = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.android))
            .position(homeLatLng, overlaySize)
        map.addGroundOverlay(googleOverlay)

        setMapLongClick(map)
        setPoiClick(map)
        setMapStyle(map)
        enableMyLocation()
    }

    // Initializes contents of Activity's standard options menu. Only called the first time options
    // menu is displayed.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.i("checking", "called")
        val inflater = menuInflater
        inflater.inflate(R.menu.map_options, menu)
        return true
    }

    // Called whenever an item in your options menu is selected.
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            map.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    // Called when user makes a long press gesture on the map.
    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener { latLng ->
            // A Snippet is Additional text that's displayed below the title.
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1$.5f, Long: %2$.5f",
                latLng.latitude,
                latLng.longitude
            )
            map.addMarker(
                MarkerOptions()
                    .position(latLng)
                    .title(getString(R.string.dropped_pin))
                    .snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )
        }
    }

    // Places a marker on the map and displays an info window that contains POI name.
    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { poi ->
            val poiMarker = map.addMarker(
                MarkerOptions()
                    .position(poi.latLng)
                    .title(poi.name)
            )
            poiMarker.showInfoWindow()
        }
    }

    // Allows map styling and theming to be customized.
    private fun setMapStyle(map: GoogleMap) {
        try {
            // Customize the styling of the base map using a JSON object defined
            // in a raw resource file.
            val success = map.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.map_style
                )
            )

            if (!success) {
                Log.e(TAG, "Style parsing failed.")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e(TAG, "Can't find style. Error: ", e)
        }
    }

    // Checks that users have given permission
    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    // Checks if users have given their location and sets location enabled if so.
    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    // Callback for the result from requesting permissions.
    // This method is invoked for every call on requestPermissions(android.app.Activity, String[],
    // int).
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        // Check if location permissions are granted and if so enable the
        // location data layer.
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }
}
