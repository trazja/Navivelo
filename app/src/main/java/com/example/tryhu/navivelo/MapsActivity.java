package com.example.tryhu.navivelo;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
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
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import org.joda.time.DateTime;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
       protected GeoDataClient mGeoDataClient;
       protected PlaceDetectionClient mPlaceDetectionClient;

       Place start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        autocompleteFragmentStart= (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_start);
        autocompleteFragmentStart.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Log.i(TAG, "Place: " + place.getName());
                start = place;
            }

            @Override
            public void onError(Status status) {
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        autocompleteFragmentEnd = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_end);
        autocompleteFragmentEnd.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                Log.i(TAG, "Place: " + place.getName());

                final DateTime now = new DateTime();

                //com.google.android.gms.maps.model.LatLng
                final LatLng startLatLng = start.getLatLng();
                final LatLng endLatLng = place.getLatLng();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final DirectionsResult result = DirectionsApi.newRequest(getGeoContext())
                                        .mode(TravelMode.DRIVING).origin(new com.google.maps.model.LatLng(startLatLng.latitude, startLatLng.longitude))
                                        .destination(new com.google.maps.model.LatLng(endLatLng.latitude, endLatLng.longitude)).departureTime(now)
                                        .await();

                                //eventbus.post(obiekt typu JakisTyp)

                            /*Handler handler = new Handler(getMainLooper());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                }
                            });*/

                            } catch (ApiException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();



                    int a =5;
                    Log.d("",a+"");

            }

            @Override
            public void onError(Status status) {
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        mapFragment.getMapAsync(this);
         mGeoDataClient = Places.getGeoDataClient(this, null);
         mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);

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

    @Override
    protected void onStart() {
        super.onStart();
        //register eventbus
    }

    //@Subscribe
    //public void getResult(JakisTyp obiekt){ ....}



    PlaceAutocompleteFragment autocompleteFragmentStart;
       PlaceAutocompleteFragment autocompleteFragmentEnd ;

       // autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            public String TAG;


    private GeoApiContext getGeoContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext.setQueryRateLimit(3).setApiKey(getString(R.string.google_maps_key))
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }


    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap=googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney=new LatLng(-34,151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

        AsyncTask<String, Integer, Object> myTask = new AsyncTask<String, Integer, Object>() {

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
            }

            @Override
            protected Object doInBackground(String... strings) {
                return null;
            }
        };
}










