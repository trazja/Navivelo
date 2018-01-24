package com.example.tryhu.navivelo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectRouteFragment extends Fragment {


    public SelectRouteFragment() {

    }


    private MapView mapView;
    private MapController mapController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context ctx = getActivity().getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        return inflater.inflate(R.layout.fragment_select_route, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {


            mapView = (MapView) view.findViewById(R.id.simplyMap);
            mapView.setBuiltInZoomControls(true);
            mapView.setMultiTouchControls(true);
            mapController = (MapController) this.mapView.getController();
            mapController.setZoom(1);
            mapView.setTileSource(TileSourceFactory.MAPNIK);

            Button naviSettingsButton = (Button) view.findViewById(R.id.naviSettingsButton);

            naviSettingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent settingsIntent = new Intent(getContext(), ItemFragment.class);
                    SelectRouteFragment.this.startActivity(settingsIntent);*/

                    getActivity().getFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, new ItemFragment())
                            .addToBackStack(null)
                            .commit();
                }
            });

            PlaceAutocompleteFragment auto = (PlaceAutocompleteFragment) getActivity()
                    .getFragmentManager()
                    .findFragmentById(R.id.place_autocomplete_fragment);

            auto.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onPlaceSelected(Place place) {

                }

                @Override
                public void onError(Status status) {

                }
            });
        }
    }


    public void onResume() {
        super.onResume();

        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
    }


    public void onClickNaviSettings(View view) {

    }

}
