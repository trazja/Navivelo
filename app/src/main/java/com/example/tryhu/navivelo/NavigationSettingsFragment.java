package com.example.tryhu.navivelo;


import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceFragment;


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

}
