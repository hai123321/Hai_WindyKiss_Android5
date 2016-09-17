package com.example.namhai.ex03_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity02 extends AppCompatActivity {
    private TextView mainText;
    private Button button;

    private int[] onStatusB = new int[7];
    private String TAG = this.getClass().getName();
    //onCreate, onStart, onRestart, onResume, onPause, onStop và onDestroy


    protected void setMaiTextViewB() {
        mainText.setText(String.format("onCreate: %d\n" +
                        "onStart: %d\n" +
                        "onRestart: %d\n" +
                        "onResume: %d\n" +
                        "onPause: %d\n" +
                        "onStop: %d\n" +
                        "onDestroy:  %d\n",
                onStatusB[0],
                onStatusB[1],
                onStatusB[2],
                onStatusB[3],
                onStatusB[4],
                onStatusB[5],
                onStatusB[6]
        ));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onStatusB[0]++;
        setContentView(R.layout.activity_02);
        getReferences();
        addListener();
        setMaiTextViewB();
    }


    @Override
    protected void onStart() {
        super.onStart();
        onStatusB[1]++;
        Log.d(TAG, "onStart");
        setMaiTextViewB();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onStatusB[2]++;
        Log.d(TAG, "onRestart");
        setMaiTextViewB();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onStatusB[3]++;
        Log.d(TAG, "onResume");
        setMaiTextViewB();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onStatusB[4]++;
        Log.d(TAG, "onPause");
        setMaiTextViewB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onStatusB[5]++;
        Log.d(TAG, "onStop");
        setMaiTextViewB();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onStatusB[6]++;
        Log.d(TAG, "onDestroy");
        setMaiTextViewB();
    }

    protected void getReferences() {
        mainText = (TextView) findViewById(R.id.textViewMainB);
        button = (Button) findViewById(R.id.buttonBack);
        Log.d(TAG, "GetRegereces");
    }

    protected void addListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity02.this, Activity01.class);
                startActivity(intent);
            }
        });
    }
}
