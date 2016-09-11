package com.example.namhai.session02;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private Camera camera;

    public void getReferences() {
        tgFlashLight = (ToggleButton) findViewById(R.id.flash);
    }

    public void addListeners() {
        tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("tsbFlashLight check changed %s", isChecked));
                //1
                Camera.Parameters params = camera.getParameters();
                if (isChecked) {
                    //2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    //3
                    camera.setParameters(params);
                    camera.startPreview();
                } else {
                    //2
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    //3
                    camera.setParameters(params);
                    camera.startPreview();
                }
            }
        });
    }

    public void getCamera() {
//        try {
            camera = Camera.open();
//        } catch (Exception e) {
//            Log.d(TAG, e.getMessage());
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //co hoi cuoi cung truoc khi kill app
        super.onCreate(savedInstanceState);
        //1
        getCamera();
        //2
        setContentView(R.layout.activity_main);
        //3
        getReferences();
        //4
        addListeners();
        tgFlashLight.setChecked(true);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        tgFlashLight.setChecked(false);
        super.onDestroy();

    }
}
