package com.example.windykiss.homework15_0102;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.iv_st_gen1)
    ImageView iv_st_gen1;
    @BindView(R.id.iv_st_gen2)
    ImageView iv_st_gen2;
    @BindView(R.id.iv_st_gen3)
    ImageView iv_st_gen3;
    @BindView(R.id.iv_st_gen4)
    ImageView iv_st_gen4;
    @BindView(R.id.iv_st_gen5)
    ImageView iv_st_gen5;
    @BindView(R.id.iv_st_gen6)
    ImageView iv_st_gen6;


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        ButterKnife.bind(this, v);
        addListeners(v);
        return v;
    }

    private void addListeners(View v) {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        blur(iv_st_gen1);
        blur(iv_st_gen2);
        blur(iv_st_gen3);
        blur(iv_st_gen4);
        blur(iv_st_gen5);
        blur(iv_st_gen6);


    }

    public void blur(final ImageView iv) {
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ColorDrawable) iv.getBackground()).getColor() == Color.parseColor("#00FFFFFF")) {
                    iv.setBackgroundColor(
                            Color.parseColor("#88FFFFFF")
                    );
                } else {
                    iv.setBackgroundColor(
                            Color.parseColor("#00FFFFFF")
                    );
                }

            }
        });
    }

}
