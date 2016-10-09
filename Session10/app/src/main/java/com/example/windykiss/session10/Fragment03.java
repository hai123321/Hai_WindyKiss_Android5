package com.example.windykiss.session10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment03 extends Fragment {

    private Button btn_back;
    private View v;

    public Fragment03() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment03, container, false);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        addListener(v);
    }

    public void addListener(View v){
        btn_back = (Button) v.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).popAll();
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
    }
}
