package com.example.windykiss.lab01_sesson06;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    static ImageView imgBtn;
    static CustomScrollView customScrollView;
    private String TAG = MainActivity.class.getName();
//    RelativeLayout aboveFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main2);
        setupUI();
    }

    public void setupUI() {
        imgBtn = (ImageView) findViewById(R.id.btn);
        customScrollView = (CustomScrollView) findViewById(R.id.scroll);
//        aboveFragment = (RelativeLayout) findViewById(R.id.aboveViewFragment);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "BTN clicked");

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                DetailFragment detailFragment = new DetailFragment();

//                aboveFragment.getLayoutParams().height = customScrollView.getScrollY();

                fragmentTransaction.replace(R.id.viewFragment, detailFragment);

                customScrollView.setEnableScrolling(false);

                imgBtn.setEnabled(false);

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

//                customScrollView.setEnableScrolling(true);

            }
        });



    }




}
