package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PickLocation extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    boolean isPermissionGranted = false;
    FloatingActionButton buttonmap;
    SupportMapFragment supportMapFragment;
    private FusedLocationProviderClient client;
    private ConnectivityManager manager;
    private NetworkInfo networkInfo;
    private int REQUEST_CODE = 111;
    Geocoder geocoder;
    private double selectedlat, selectedlong;
    private List<Address> addresses;
    private String selectedaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_location);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(PickLocation.this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
        Intent intent=getIntent();
        Double lat=intent.getDoubleExtra("lat",-34);
        Double lon=intent.getDoubleExtra("lon",151);

        LatLng sydney = new LatLng(lat,lon);
        mMap.addMarker(new MarkerOptions().position(sydney).draggable(true).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(sydney, 15.5f);
        googleMap.moveCamera(update);

        // Enable the zoom controls for the map
        mMap.getUiSettings().setZoomControlsEnabled(true);

        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
            }

            @Override
            public void onMarkerDrag(Marker marker) {
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng latLng = marker.getPosition();
                Geocoder geocoder = new Geocoder(PickLocation.this, Locale.getDefault());
                try {
                    if (geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1).size() > 0) {
                        Address address = geocoder.
                                getFromLocation(latLng.latitude, latLng.longitude, 1).get(0);
                       Log.i("LocationPIck", latLng.latitude + " " + latLng.longitude);
                        Become_Donor_Activity.lat = String.valueOf(latLng.latitude);
                        Become_Donor_Activity.lon = String.valueOf(latLng.longitude);
                    }
                    else
                        Toast.makeText(PickLocation.this,"Please Select a Correct Lication", Toast.LENGTH_SHORT);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}