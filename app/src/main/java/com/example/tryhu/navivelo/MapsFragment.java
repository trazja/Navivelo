package com.example.tryhu.navivelo;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    //   protected GeoDataClient mGeoDataClient;
    //   protected PlaceDetectionClient mPlaceDetectionClient;

    public MapsFragment() {
        // Required empty public constructor
    }

    private MapsFragmentListener listener;

    public interface MapsFragmentListener{

    };

    SupportPlaceAutocompleteFragment  autocompleteFragmentStart;
    SupportPlaceAutocompleteFragment  autocompleteFragmentEnd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        Button naviSettingsButton = (Button) view.findViewById(R.id.navi_settings_button);


        naviSettingsButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {

                getActivity().getFragmentManager().beginTransaction()
                        .replace(R.id.mapcontainer,
                                new NavigationSettingsFragment()).addToBackStack(null).commit();

            }

        });
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        autocompleteFragmentStart = (SupportPlaceAutocompleteFragment)
                getChildFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_start);
        autocompleteFragmentEnd = (SupportPlaceAutocompleteFragment )
                getChildFragmentManager().findFragmentById(R.id.place_autocomplete_fragment_end);

        return view;

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
    }

    // autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
    public String TAG;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
