package com.example.tryhu.navivelo;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;


public class ItemFragment extends ListFragment {


    private int mColumnCount = 2;

    interface ItemFragmentListener {
        void itemClicked(long id);
    }

    private ItemFragmentListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        String[] settings = new String[Items.items.length];


        for (int i = 0; i < settings.length; i++) {
            settings[i] = Items.items[i].getName();
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_multiple_choice,
                settings){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                String setting = getItem(position);

                if(convertView == null){
                    convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
                }

                ((CheckedTextView)convertView.findViewById(android.R.id.text1)).setText(setting);

                return super.getView(position, convertView, parent);
            }
        };
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (ItemFragmentListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }


}
