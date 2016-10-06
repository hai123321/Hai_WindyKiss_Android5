package com.example.windykiss.lab03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment05 extends Fragment {


    public Fragment05() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment05, container, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.listView.setEnabled(true);
    }
}
