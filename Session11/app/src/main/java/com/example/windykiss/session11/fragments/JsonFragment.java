package com.example.windykiss.session11.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.windykiss.session11.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class JsonFragment extends Fragment {


    private static final String TAG = JsonFragment.class.getName();
    @BindView(R.id.lv_main)
    ListView lv_main;


    public JsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_json, container, false);
        ButterKnife.bind(this, v);

        return v;
    }


}
