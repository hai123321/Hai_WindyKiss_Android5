package com.example.windykiss.session10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment01 extends Fragment {


    public Fragment01() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment01, container, false);

        return v;
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
