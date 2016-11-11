package com.example.windykiss.homework15_0102;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.view)
    View v1;

    @BindView(R.id.view2)
    View v2;

    Boolean change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        change = true;
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combo();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        menu.findItem(R.id.mni_animate)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Log.d(TAG, "onMenuItemClick");
//                        translate();
                        if (change) {
                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.anim.enter, R.anim.exit)
                                    .replace(R.id.fl, new BlueFragment()).commit();
                            change = false;
                        } else{
                            getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.anim.enter, R.anim.exit)
                                    .replace(R.id.fl, new RedFragment()).commit();
                            change = true;
                        }
//                        rotate();
//                        rotateXML();
//                        combo();
//                        scale();
//                        alpha();
//                        if (v1.getVisibility() == View.VISIBLE) {
//                            v1.setVisibility(View.INVISIBLE);
//                        } else {
//                            v1.setVisibility(View.VISIBLE);
//                        }
//
//                        if (v2.getVisibility() == View.VISIBLE) {
//                            v2.setVisibility(View.INVISIBLE);
//                        } else {
//                            v2.setVisibility(View.VISIBLE);
//                        }
                        return false;
                    }
                })
        ;

        return true;
    }

    private void combo() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        float width = size.x;
        float height = size.y;

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        animationSet.setDuration(1000);

        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, width / v1.getWidth(),
                1, 1
        );

        animationSet.addAnimation(scaleAnimation);


        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, -v1.getX(),
                0, -v1.getY()
        );


        animationSet.addAnimation(translateAnimation);


        v1.startAnimation(animationSet);
    }

    void translate() {
        // 1:Create animation
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 500,
                0, 500
        );


        translateAnimation.setDuration(300);
        //ko tro lai
        translateAnimation.setFillAfter(true);
        //set gia toc
        translateAnimation.setInterpolator(new LinearInterpolator());

        // 2: Animate
        v1.startAnimation(translateAnimation);
    }

    void translateByXML() {
        //1: Load Animation from XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_to_right);

        v1.startAnimation(animation);

    }

    void rotate() {
        //1. Create Animation
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 3600,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setRepeatCount(RotateAnimation.INFINITE);

        rotateAnimation.setDuration(100);
        rotateAnimation.setFillAfter(true);
//        rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        //2.Animated
        v1.startAnimation(rotateAnimation);
    }

    void rotateXML() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_circle);
        v1.startAnimation(animation);
    }


    void scale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1, 2,
                1, 3
        );
        scaleAnimation.setDuration(1000);
//        scaleAnimation.setFillAfter(true);
        v1.startAnimation(scaleAnimation);
    }

    void alpha() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(
                1, 0
        );
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
        v1.startAnimation(alphaAnimation);

    }


}
