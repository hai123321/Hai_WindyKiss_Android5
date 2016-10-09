package com.example.windykiss.session10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment04 extends Fragment {


    public Fragment04() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fragment04, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).setDefaultMenuBar();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
