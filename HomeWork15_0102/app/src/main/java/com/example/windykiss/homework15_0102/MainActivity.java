package com.example.windykiss.homework15_0102;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.windykiss.homework15_0102.adapters.PostAdapter;
import com.example.windykiss.homework15_0102.models.PostModel;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getName();
    private String URL = "https://a5-tumblelog.herokuapp.com/";

    String responseBodyString;

    private PostAdapter postAdapter;

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        changeFragment();
//
//        setupUI();
//        sendGETRequest();

    }


    private void sendGETRequest() {

        Request request = new Request.Builder()
                .url(URL)
                .build();

        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    responseBodyString = response.body().string();

                    Log.d(TAG, "GET\n" + responseBodyString);

                    PostJSONModel[] postJSONModels = (new Gson()).fromJson(responseBodyString, PostJSONModel[].class);

                    PostModel.list.clear();

                    for (PostJSONModel postJSONModel : postJSONModels) {
                        PostModel.list.add(
                                new PostModel(
                                        postJSONModel.getContent(),
                                        postJSONModel.getTitle()
                                )
                        );
                    }

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postAdapter.notifyDataSetChanged();
                        }
                    });


                }

            }
        });
    }

    private void setupUI() {
        //1 Setup Layoutmanager
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, 0);
        //Homework StaggeredGridLayoutManager
        recyclerView.setLayoutManager(layoutManager);

        //2 Setup Adapter
        postAdapter = new PostAdapter();
        recyclerView.setAdapter(postAdapter);
    }

    private void changeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        LoginFragment detailFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.activity_main, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
