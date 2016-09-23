package com.example.namhai.session03;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

public class MainActivity extends AppCompatActivity {


    /*
    "FPT Software", "0473007575", "https://www.fpt-software.com"
"EWay", "+84432595450", "https://eway.vn"
"KMS", "+84838486888", "http://www.kms-technology.com"
"BraveBits", " +84463260066", "http://www.bravebits.vn"
"TechKids", "+841653005670", "http://techkids.vn"
     */

    private static final String[][] list = {
            {"FPT Software", "0473007575", "https://www.fpt-software.com"},
            {"EWay", "+84432595450", "https://eway.vn"},
            {"KMS", "+84838486888", "http://www.kms-technology.com"},
            {"BraveBits", " +84463260066", "http://www.bravebits.vn"},
            {"TechKids", "+841653005670", "http://techkids.vn"}
    };


    public static ArrayList<Company> arrayListCompany = new ArrayList<>();

    private ListView listView;
    private String TAG = this.getClass().getName();


    ArrayAdapter<String> companyListAdapter;
    ArrayList<String> nameCompany = new ArrayList<>();

    public void add() {
        for (int i = 0; i < list.length; i++) {
            Company tmp = new Company(list[i][0], list[i][2], list[i][1]);
            arrayListCompany.add(tmp);
            nameCompany.add(tmp.getName());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getReferences();
        setupUI();
        addListener();


    }

    protected void addListener() {

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Position in Long Click list %d", position));
                arrayListCompany.remove(position);
                companyListAdapter.notifyDataSetChanged();
                //return quyet dinh Click short co duoc xu li hay k
                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, String.format("Position in Click list %d", position));
//                //change scenes

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setPosition(position);

                if (findViewById(R.id.fl_container) != null) {

                    fragmentTransaction.replace(R.id.fl_container, detailFragment);

                } else {
//                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                    // chuyen item
//                    intent.putExtra("SendText", String.format("%s\n%s\n%s",
//                            arrayListCompany.get(position).getName(),
//                            arrayListCompany.get(position).getWebsite(),
//                            arrayListCompany.get(position).getPhone()));
//
//                    startActivity(intent);
                    fragmentTransaction.replace(R.id.layout_list, detailFragment);
                }
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();


            }
        });
    }


    protected void getReferences() {
        listView = (ListView) findViewById(R.id.listView);
    }

    protected void setupUI() {
        add();
        companyListAdapter = new ArrayAdapter<>(
                this,
                R.layout.simple_list_item,
                nameCompany
        );
        listView.setAdapter(companyListAdapter);


    }
}
