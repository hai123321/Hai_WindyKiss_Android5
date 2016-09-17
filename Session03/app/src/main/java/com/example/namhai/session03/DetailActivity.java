package com.example.namhai.session03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getReferences();
        addListener();
        editText.setText(getIntent2());
    }

    protected void getReferences() {
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.buttonSave);
    }

    protected String getIntent2(){
        Intent intent = getIntent();
        return intent.getStringExtra("SendText");
//        Log.d(TAG, String.format("Name %s", a));
    }

    protected int getPosIntent(){
        Intent intent = getIntent();
        return intent.getIntExtra("Pos", -1);
    }

    protected void addListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                String tmp = editText.getText().toString();
                String s1 = tmp.substring(0, tmp.indexOf("\n"));
                String s2 = tmp.substring(tmp.indexOf("\n"));
                if(getPosIntent() != -1){
                    MainActivity.arrayListAndroid.set(getPosIntent(), s1);
                    MainActivity.arrayListAndroidDetail.set(getPosIntent(), s2);
                } else {
                    MainActivity.arrayListAndroid.add(s1);
                    MainActivity.arrayListAndroidDetail.add(s2);
                }
                startActivity(intent);

            }
        });
    }
}
