package com.example.windykiss.lab03;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment01 extends Fragment {

    private Button btn_back;

    public Fragment01() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment01, container, false);
        addListener(v);
        return v;
    }

    public void addListener(View v){
        btn_back = (Button) v.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
                MainActivity.listView.setEnabled(true);
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        MainActivity.listView.setEnabled(true);
    }

}
