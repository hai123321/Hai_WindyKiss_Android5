package com.example.namhai.session03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private static final String[] androidList = new String[]{
            "Tools for learning Android", "Activity", "Fragment", "View"
    };

    private static final String[] androidListDetail = new String[]{
            "- PC or MAC with at least 4GB RAM\n" +
                    "- Android Studio\n" +
                    "- Genymotion or other simulation tools",
            "-Learn\n" +
                    "-Code\n" +
                    "-Eat", "Fragment...", "View..."
    };

    public static ArrayList<String> arrayListAndroid = new ArrayList<>(Arrays.asList(androidList));
    public static ArrayList<String> arrayListAndroidDetail = new ArrayList<>(Arrays.asList(androidListDetail));

    private ListView listView;
    private Button add;
    private EditText editText;
    private String TAG = this.getClass().getName();

    ArrayAdapter<String> androidListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();


    }

    protected void addListener() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("SendText", "");
                startActivity(intent);
                ;
                Log.d(TAG, "Click btn ADD");

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Position in Long Click list %d", position));
                arrayListAndroid.remove(position);
                arrayListAndroidDetail.remove(position);
                androidListAdapter.notifyDataSetChanged();
                //return quyet dinh Click short co duoc xu li hay k
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Position in Click list %d", position));
                //change scenes
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                // chuyen item
                intent.putExtra("SendText", String.format("%s\n%s", arrayListAndroid.get(position), arrayListAndroidDetail.get(position)));
                intent.putExtra("Pos", position);
                startActivity(intent);
            }
        });
    }


    protected void getReferences() {
        listView = (ListView) findViewById(R.id.listView);
        add = (Button) findViewById(R.id.buttonAdd);
        editText = (EditText) findViewById(R.id.editText);
    }

    protected void setupUI() {
        androidListAdapter = new ArrayAdapter<>(
                this,
                R.layout.simple_list_item,
                arrayListAndroid
        );
        listView.setAdapter(androidListAdapter);


    }
}
