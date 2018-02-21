package com.example.tryhu.navivelo;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.places.PlaceDetectionClient;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    //   protected GeoDataClient mGeoDataClient;
    //   protected PlaceDetectionClient mPlaceDetectionClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
       //  mGeoDataClient = Places.getGeoDataClient(this, null);
     //    mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);


//        @Override
//        public void onPlaceSelected(Place place) {
//            // TODO: Get info about the selected place.
//            Log.i(TAG, "Place: " + place.getName());
//        }

//        @Override
//        public void onError(Status status) {
//            // TODO: Handle the error.
//            Log.i(TAG, "An error occurred: " + status);
//        }

        Button naviSettingsButton = (Button) findViewById(R.id.navi_settings_button);

        naviSettingsButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction()
                        .replace(R.id.container,
                                new NavigationSettingsFragment()).addToBackStack(null).commit();

            }
        });


    }


    PlaceAutocompleteFragment autocompleteFragmentStart = (PlaceAutocompleteFragment)
            getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_start);
       PlaceAutocompleteFragment autocompleteFragmentEnd = (PlaceAutocompleteFragment)
            getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_end);

       // autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            public String TAG;





    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap=googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney=new LatLng(-34,151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }}










