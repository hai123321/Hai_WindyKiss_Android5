package com.example.windykiss.session11.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.windykiss.session11.R;
import com.example.windykiss.session11.managers.Preferences;
import com.example.windykiss.session11.models.FragmentEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.et_typeName)
    EditText et_typeName;

    @BindView(R.id.btn_save)
    Button btn_save;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this , v);
        return v;
    }

    @OnClick(R.id.btn_save)
    public void onClick(View v){
        //1. Get String
        String userName = et_typeName.getText().toString();
        //2. Save data to SharedReference
        Preferences.getInstance().putUserName(userName);
        //3. Transit to Quote Fragment
        EventBus.getDefault().post(new FragmentEvent(
                new QuoteFragment(),
                false
        ));
    }

}
