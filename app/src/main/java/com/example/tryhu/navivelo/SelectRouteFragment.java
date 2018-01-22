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

import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;

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

        return inflater.inflate(R.layout.fragment_select_route, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Context ctx = getApplicationContext();


            Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));


            mapView = getView(R.id.simplyMap);
            mapView.setBuiltInZoomControls(true);
            mapView.setMultiTouchControls(true);
            mapController = (MapController) this.mapView.getController();
            mapController.setZoom(1);
            mapView.setTileSource(TileSourceFactory.MAPNIK);

            Button naviSettingsButton = (Button) findViewbyId(R.id.naviSettingsButton);

            naviSettingsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent settingsIntent = new Intent(SelectRouteFragment, ItemFragment.class);
                    SelectRouteFragment.this.startActivity(settingsIntent);

                }




        });

}}


    public void onResume() {
        super.onResume();

        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }


    public void onClickNaviSettings(View view) {

    }

}
