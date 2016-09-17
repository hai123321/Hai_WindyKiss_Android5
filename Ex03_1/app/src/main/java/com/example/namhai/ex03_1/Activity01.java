package com.example.namhai.ex03_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity01 extends AppCompatActivity {

    TextView maiTextView;
    Button button;

    int[] onStatusA = new int[7];
    private String TAG = this.getClass().getName();
    //onCreate, onStart, onRestart, onResume, onPause, onStop và onDestroy


    protected void setMaiTextView() {
        maiTextView.setText(String.format("onCreate: %d\n" +
                        "onStart: %d\n" +
                        "onRestart: %d\n" +
                        "onResume: %d\n" +
                        "onPause: %d\n" +
                        "onStop: %d\n" +
                        "onDestroy:  %d\n",
                onStatusA[0],
                onStatusA[1],
                onStatusA[2],
                onStatusA[3],
                onStatusA[4],
                onStatusA[5],
                onStatusA[6]
        ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onStatusA[0]++;
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_01);
        getReferences();
        addListener();
        setMaiTextView();
    }


    @Override
    protected void onStart() {
        super.onStart();
        onStatusA[1]++;
        Log.d(TAG, "onStart");
        setMaiTextView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onStatusA[2]++;
        Log.d(TAG, "onRestart");
        setMaiTextView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onStatusA[3]++;
        Log.d(TAG, "onResume");
        setMaiTextView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onStatusA[4]++;
        Log.d(TAG, "onPause");
        setMaiTextView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onStatusA[5]++;
        Log.d(TAG, "onStop");
        setMaiTextView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onStatusA[6]++;
        Log.d(TAG, "onDestroy");
        setMaiTextView();
    }

    protected void getReferences() {
        maiTextView = (TextView) findViewById(R.id.textViewMainText);
        button = (Button) findViewById(R.id.button);
    }

    protected void addListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity01.this, Activity02.class);
                startActivity(intent);
            }
        });
    }

}
