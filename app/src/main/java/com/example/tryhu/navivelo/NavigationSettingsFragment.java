package com.example.tryhu.navivelo;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.View;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationSettingsFragment extends PreferenceFragment {


    public NavigationSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.navigation_settings_preferences);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.setBackgroundColor(Color.WHITE);

    }

}
