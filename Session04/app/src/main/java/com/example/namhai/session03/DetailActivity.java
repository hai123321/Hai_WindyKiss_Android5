package com.example.namhai.session03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView textViewName;
    private TextView textViewWeb;
    private TextView textViewPhone;

    private String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getReferences();
        addListener();
        String[] split= getIntent2().split("\n");
        textViewName.setText(split[0]);
        textViewWeb.setText(split[1]);
        textViewPhone.setText(split[2]);
    }

    protected void getReferences() {
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewWeb = (TextView) findViewById(R.id.textViewWeb);
        textViewPhone = (TextView) findViewById(R.id.textViewPhone);
    }

    protected String getIntent2() {
        Intent intent = getIntent();
        return intent.getStringExtra("SendText");
//        Log.d(TAG, String.format("Name %s", a));
    }


    protected void addListener() {


        textViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String googleSearch = String.format("%s", textViewWeb.getText());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearch));
                startActivity(intent);
            }
        });

        textViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = textViewPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });
    }
}
