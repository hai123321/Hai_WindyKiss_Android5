package com.example.windzlord.x_lab6;

import android.app.Application;
import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.util.Log;

import com.example.windzlord.x_lab6.managers.DBHelper;
import com.example.windzlord.x_lab6.managers.FileManager;
import com.example.windzlord.x_lab6.managers.NetworkManager;
import com.example.windzlord.x_lab6.managers.Preferences;
import com.example.windzlord.x_lab6.models.Quote;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by WindzLord on 10/12/2016.
 */

public class QuoteApplication extends Application {

    private static final String TAG = QuoteApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()).build());
        Preferences.init(this);
        NetworkManager.init(this);
        FileManager.init(this);
        DBHelper.init(this);



//        Insert
//        Quote quote = new Quote("Hai", "ABCDEFGH");

//        DBHelper.getInstance().insert(
//                quote
//        );

//        Delete All
//        DBHelper.getInstance().deleteAllQuote();

//        DBHelper.getInstance().delete(quote);

        for (Quote q : DBHelper.getInstance().selectAllQuote()){
            Log.d(TAG, q.toString() + q.getContent());
        }
//        Log.d(TAG, DBHelper.getInstance().getRandomQuote().toString());
    }
}
