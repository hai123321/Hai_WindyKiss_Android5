package com.example.windykiss.session11.fragments;


import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windykiss.session11.Constants.Constants;
import com.example.windykiss.session11.MainActivity;
import com.example.windykiss.session11.R;
import com.example.windykiss.session11.jsmodels.QuoteJSONModel;
import com.example.windykiss.session11.managers.Preferences;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.getName();

    @BindView(R.id.iv_bg)
    ImageView iv_bg;

    @BindView(R.id.tv_content)
    TextView tv_content;

    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_username)
    TextView tv_username;


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, v);
        setupUI();
        return v;
    }

    private void updateQuote(final QuoteJSONModel quoteJSONModel) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_title.setText(quoteJSONModel.getTitle());
                tv_content.setText(Html.fromHtml(quoteJSONModel.getContent().replaceAll("\n", "")));
            }
        });

    }

    private void setupUI() {
        //Image
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(Constants.UNPLASH_API, iv_bg, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                //User Name
                tv_username.setText(String.format("Hello %s", Preferences.getInstance().getUserName()));
                // 1 Create Client
                OkHttpClient client = new OkHttpClient();

                // 2 Create Request
                Request request = new Request
                        .Builder()
                        .url(Constants.QUOTE_API)
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
                        Log.d(TAG, "onResponse");
//                Log.d(TAG, String.format("ResponseBody %s", response.body().string()));
                        // Only use Response Body 1 time

                        //Create Gson
                        Gson gson = new Gson();
                        //Parse
                        //Neu co ngoac vuong o ngoai thi them mang X[] con ngoac nhon thi X.class
                        QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

                        if (quotes.length > 0) {
                            QuoteFragment.this.updateQuote(quotes[0]);
                        }
                    }
                });

                // 5
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });


    }

}
