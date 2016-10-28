package com.example.windzlord.x_lab6.fragments;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.windzlord.x_lab6.R;
import com.example.windzlord.x_lab6.constant.Constant;
import com.example.windzlord.x_lab6.jsonmodels.QuoteJSONModel;
import com.example.windzlord.x_lab6.managers.DBHelper;
import com.example.windzlord.x_lab6.managers.FileManager;
import com.example.windzlord.x_lab6.managers.NetworkManager;
import com.example.windzlord.x_lab6.managers.Preferences;
import com.example.windzlord.x_lab6.models.FragmentEvent;
import com.example.windzlord.x_lab6.models.Quote;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import butterknife.OnClick;
import okhttp3.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {

    private static final String TAG = QuoteFragment.class.getName();
    @BindView(R.id.imageView_background)
    ImageView imageViewBackGround;

    @BindView(R.id.textView_content)
    TextView textViewContent;

    @BindView(R.id.textView_title)
    TextView textViewTitle;

    @BindView(R.id.textView_username)
    TextView textViewUsername;

    @BindView(R.id.button_getOut)
    Button buttonGetOut;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qoute, container, false);

        settingThingsUp(view);
        setupUI();

        return view;
    }

    private void settingThingsUp(View view) {
        ButterKnife.bind(this, view);
    }

    private void setupUI() {
//        textViewUsername.setText("Hello " + Preferences.getInstance().getUsername().replaceAll("\n", " "));
        textViewUsername.setText("Hello Nam Hai!!!");

        // Load image to data offline when Online


        // Get image from data offline
        File file;
        if (NetworkManager.getInstance().isConnectedToInternet()) {

            ImageLoader.getInstance().loadImage(Constant.UNSPLASH_API, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                    FileManager.getInstance().createImage(loadedImage, "unSplash"+ FileManager.imgCount);
                    FileManager.getInstance().createImage(loadedImage, "unSplash");
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });

            file = FileManager.getInstance().loadImageFile("unSplash");
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(Constant.QUOTE_API).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println("onFailure");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println("onResponse");
                    String bodyString = response.body().string();

                    Gson gson = new Gson();
                    QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

                    final String title = quotes[0].getTitle();
                    final String content = quotes[0].getContent();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textViewTitle.setText(title);
                            textViewContent.setText("        " + Html.fromHtml(content));
                        }
                    });
                }
            });
            Log.d(TAG, DBHelper.getInstance().selectAllQuote().size() +"");

            if (DBHelper.getInstance().selectAllQuote().size() == 0) {
                for (int i = 0; i < 10; i++) {
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String bodyString = response.body().string();
                            Gson gson = new Gson();
                            QuoteJSONModel[] quotes = gson.fromJson(bodyString, QuoteJSONModel[].class);

                            String title = quotes[0].getTitle();
                            String content = quotes[0].getContent();

                            DBHelper.getInstance().insert(new Quote(
                                    title,
                                    content
                            ));
                        }
                    });
                }
            }
        } else{
            Random in = new Random();
//            file = FileManager.getInstance().loadImageFile("unSplash" + FileManager.imgCount);
            file = FileManager.getInstance().loadImageFile("unplashImage"+in.nextInt(10));
            Quote quote = DBHelper.getInstance().getRandomQuote();
            textViewTitle.setText(quote.getTitle());
            textViewContent.setText("        " + Html.fromHtml(quote.getContent()));
        }

        ImageLoader.getInstance().displayImage(Uri.fromFile(file).toString(), imageViewBackGround);


    }

    @OnClick(R.id.button_getOut)
    public void onClick(View view) {
        Preferences.getInstance().clearCache();
        EventBus.getDefault().post(new FragmentEvent(
                new RegisterFragment(), false
        ));
    }

}
