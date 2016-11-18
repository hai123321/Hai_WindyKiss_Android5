package com.example.windykiss.homework15_0102;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.iv_play)
    ImageView iv_play;

    @BindView(R.id.iv_setting)
    ImageView iv_setting;

    @BindView(R.id.tv_hs)
    TextView tv_hs;

    @BindView(R.id.tv_hs_num)
    TextView tv_hs_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        settingUI();
        addListener();
    }

    private void addListener() {
        iv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new PlayFragment(), true);
            }
        });

        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new SettingFragment(), true);
            }
        });
    }


    public void settingUI(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        iv_play.setLayoutParams(new RelativeLayout.LayoutParams(2*width/5, 2*width/5));
        iv_play.setX(width/2 - width/5);
        iv_play.setY(5*height/8 - width/5);

        //High Score
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/PoplarStd.ttf");
        tv_hs.setTypeface(type);
        type = Typeface.createFromAsset(getAssets(),"fonts/StencilStd.ttf");
        tv_hs_num.setTypeface(type);
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit)
                .replace(R.id.fr_change, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}
