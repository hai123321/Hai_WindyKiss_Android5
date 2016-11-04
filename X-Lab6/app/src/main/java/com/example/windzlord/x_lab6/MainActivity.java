package com.example.windzlord.x_lab6;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.windzlord.x_lab6.constant.Constant;
import com.example.windzlord.x_lab6.fragments.QuoteFragment;
import com.example.windzlord.x_lab6.fragments.RegisterFragment;
import com.example.windzlord.x_lab6.jsonmodels.FlickrFeed;
import com.example.windzlord.x_lab6.jsonmodels.PlaceJSONModel;
import com.example.windzlord.x_lab6.managers.DBContext;
import com.example.windzlord.x_lab6.managers.NetworkManager;
import com.example.windzlord.x_lab6.managers.Preferences;
import com.example.windzlord.x_lab6.models.FragmentEvent;
import com.example.windzlord.x_lab6.models.GirlAdapter;
import com.example.windzlord.x_lab6.models.MyArrayAdapter;
import com.example.windzlord.x_lab6.services.UnplashDownloadService;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingThingsUp();

        int choice = 0;

        switch (choice) {
            case 0:
                setupUI_0();
                break;
            case 1:
                setupUI_1();
                break;
            case 2:
                setupUI_2();
                break;
            case 3:
                setupUI_3();
                break;
        }
    }

    private void setupUI_0() {
        DBContext.init(this);
        EventBus.getDefault().register(this);
//        if (Preferences.getInstance().getUsername() == null) {
//            changeFragment(new RegisterFragment(), false);
//        } else
        changeFragment(new QuoteFragment(), false);
        if (NetworkManager.getInstance().isConnectedToInternet()) {
            Intent intent = new Intent(this, UnplashDownloadService.class);
            startService(intent);
        } else{
            Log.d(TAG, "onOffline");
        }

    }

    private void setupUI_3() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        String jsonItem = new Gson().toJson(new PlaceJSONModel("123", "This is title", "This is bo cmn dy"));

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = RequestBody.create(JSON, jsonItem);

        Request request = new Request.Builder()
                .url(Constant.PLACE)
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse");
                System.out.println(response.toString());
                System.out.println(response.body().string());
            }
        });
    }

    private void setupUI_2() {
        final ArrayList<FlickrFeed.Item> arrayList = new ArrayList<>();

        final GirlAdapter girlAdapter = new GirlAdapter(
                this, R.layout.layout_girl_item, arrayList);

        ((ListView) findViewById(R.id.listView_item)).setAdapter(girlAdapter);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.GIRL).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string();
                bodyString = bodyString.substring("jsonFlickrFeed(".length(), bodyString.length() - 1);
                Gson gson = new Gson();
                FlickrFeed flickrFeed = gson.fromJson(bodyString, FlickrFeed.class);

                int i = 0;
                for (FlickrFeed.Item item : flickrFeed.getItems()) {
                    System.out.println(++i);
                    System.out.println(item.getDate());
                    System.out.println(item.getMedia().getLink());
                    arrayList.add(item);
                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        girlAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void setupUI_1() {
        final ArrayList<PlaceJSONModel> arrayList = new ArrayList<>();

        final MyArrayAdapter arrayAdapter = new MyArrayAdapter(
                this, R.layout.layout_space_item, arrayList);

        ((ListView) findViewById(R.id.listView_item)).setAdapter(arrayAdapter);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.PLACE).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String bodyString = response.body().string();
                Gson gson = new Gson();
                PlaceJSONModel[] quotes = gson.fromJson(bodyString, PlaceJSONModel[].class);

                for (PlaceJSONModel place : quotes) {
                    arrayList.add(place);
                }

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void settingThingsUp() {
        ButterKnife.bind(this);
    }

    @Subscribe
    public void onEvent(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent);
    }

    @Subscribe
    public void onEvent(String x) {
        System.out.println(x + x);
    }

    private void changeFragment(Fragment nextFragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, nextFragment);
        if (addToBackStack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void changeFragment(FragmentEvent fragmentEvent) {
        changeFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackStack());
    }

}
