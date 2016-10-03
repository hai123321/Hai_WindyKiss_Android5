package com.example.windykiss.lab01_sesson06;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getName();
//
//    @BindView(R.id.list_view)
//    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_turn3_on_measre);



        setupUI();
    }


    public void setupUI() {
//        ButterKnife.bind(this);
//        listView.setAdapter(new ListItem_Adapter(this,
//                R.layout.list_items,
//                Arrays.asList(ListItem.ARRAY)));
    }


}
