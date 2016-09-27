package com.example.namhai.ex_session06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.*;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.imv1)  ImageView imv1;
    @BindView(R.id.imv2)  ImageView imv2;
    @BindView(R.id.imv3)  ImageView imv3;
    @BindView(R.id.imv4)  ImageView imv4;
    @BindView(R.id.imv5)  ImageView imv5;
    @BindView(R.id.imv6)  ImageView imv6;
    @BindView(R.id.imv7)  ImageView imv7;
    @BindView(R.id.imv8)  ImageView imv8;
    @BindView(R.id.imv9)  ImageView imv9;
    @BindView(R.id.imv10)  ImageView imv10;
    @BindView(R.id.imv11)  ImageView imv11;
    @BindView(R.id.imv12)  ImageView imv12;
    @BindView(R.id.imv13)  ImageView imv13;
    @BindView(R.id.imv14)  ImageView imv14;
    @BindView(R.id.imv15)  ImageView imv15;
    @BindView(R.id.imv16)  ImageView imv16;
    @BindView(R.id.imv17)  ImageView imv17;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
    }

    public void setupUI(){
        ButterKnife.bind(this);
        imv1.setImageResource(R.drawable.oval_avatar);
        imv2.setImageResource(R.drawable.bitmap1);
        imv3.setImageResource(R.drawable.bitmap2);
        imv4.setImageResource(R.drawable.bitmap3);
        imv5.setImageResource(R.drawable.bitmap4);
        imv6.setImageResource(R.drawable.bitmap12);
        imv7.setImageResource(R.drawable.bitmap6);
        imv8.setImageResource(R.drawable.bitmap7);
        imv9.setImageResource(R.drawable.bitmap8);
        imv10.setImageResource(R.drawable.play_icon_group);
        imv11.setImageResource(R.drawable.bitmap11);
        imv12.setImageResource(R.drawable.bitmap10);
        imv13.setImageResource(R.drawable.albums);
        imv14.setImageResource(R.drawable.music_note);
        imv15.setImageResource(R.drawable.path);
        imv16.setImageResource(R.drawable.radio);
        imv17.setImageResource(R.drawable.search);

    }
}
