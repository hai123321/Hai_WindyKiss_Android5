package com.example.windykiss.session11;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.windykiss.session11.Constants.Constants;
import com.example.windykiss.session11.jsmodels.JSONModel;
import com.example.windykiss.session11.jsmodels.JSONModel2;
import com.example.windykiss.session11.jsmodels.JSONModel_Turn01;
import com.example.windykiss.session11.jsmodels.ListTurn02;
import com.example.windykiss.session11.models.FragmentEvent;
import com.google.gson.Gson;

import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    public ArrayList<ListTurn02> itemArrayList = new ArrayList<>();
    public ListItem_Adapter listItemAdapter;

//    @BindView(R.id.lv_main)
    ListView lv_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //neu chac chan k co thi chinh themes
//        getSupportActionBar().hide();

        //load image by universal Loader

        lv_main = (ListView) findViewById(R.id.lv_main);
        listItemAdapter = new ListItem_Adapter(this,
                R.layout.list_items,
                itemArrayList);
        lv_main.setAdapter(listItemAdapter);

        setupUI();

//        if(Preferences.getInstance().getUserName() != null){
//            changeFragment(new LoginFragment(), false);
//        } else{
//            changeFragment(new QuoteFragment(), false);
//        }

//        EventBus.getDefault().register(this);

    }


    private void setupUI() {

        // 1 Create Client
        OkHttpClient client = new OkHttpClient();

        // 2 Create Request
        Request request = new Request
                .Builder()
                .url(Constants.JSON_FLICKS)
                .build();
        // 3 Send and handle Feedback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 4
                String bodyString = response.body().string();
                bodyString= bodyString.substring(bodyString.indexOf("{")).replace("})" , "}");
                Log.d(TAG, "onResponse");
//                Log.d(TAG, String.format("ResponseBody %s", response.body().string()));
                // Only use Response Body 1 time

                //Create Gson
                Gson gson = new Gson();
                //Parse
                //Neu co ngoac vuong o ngoai thi them mang X[] con ngoac nhon thi X.class
                final JSONModel jsonModels = gson.fromJson(bodyString, JSONModel.class);

                ArrayList<JSONModel2> jsonModel2 = jsonModels.getItems();

                for(JSONModel2 jsonModel21 : jsonModel2){
                    itemArrayList.add(new ListTurn02(
                            jsonModel21.getDate_taken(),
                            jsonModel21.getMedia().getM()
                    ));
                }


                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listItemAdapter.notifyDataSetChanged();
                    }
                });

            }
        });


        // 5


    }


    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

    private void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fl_changeFragments, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
