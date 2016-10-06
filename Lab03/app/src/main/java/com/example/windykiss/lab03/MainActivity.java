package com.example.windykiss.lab03;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    public String[] main = new String[]{
            "Turn1",
            "Turn2",
            "Turn3",
            "Turn4",
            "Turn5"
    };
    public ArrayList<String> arrayList = new ArrayList<>();


    private String TAG = this.getClass().getName();

//    @BindView(R.id.lv_main)
    static ListView listView;

    ArrayAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv_main);
        getSupportActionBar().hide();
        setupUI();
        addListener();
    }

    protected void addListener() {


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Position in Click list %d", position));
//                //change scenes
                listView.setEnabled(false);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


                switch (position){
                    case 0:
                        Fragment01 detailFragment = new Fragment01();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment);
                        break;
                    case 1:
                        Fragment02 detailFragment2 = new Fragment02();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment2);
                        break;
                    case 2:
                        Fragment03 detailFragment3 = new Fragment03();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment3);
                        break;
                    case 3:
                        Fragment04 detailFragment4 = new Fragment04();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment4);
                        break;
                    case 4:
                        Fragment05 detailFragment5 = new Fragment05();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment5);
                        break;

                }



                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();


            }
        });
    }

    public void add(){
        for(String name: main){
            arrayList.add(name);
        }
    }
    protected void setupUI() {
        add();
        listAdapter = new ArrayAdapter<>(
                this,
                R.layout.simple_list_item,
                arrayList
        );
        listView.setAdapter(listAdapter);


    }
}
