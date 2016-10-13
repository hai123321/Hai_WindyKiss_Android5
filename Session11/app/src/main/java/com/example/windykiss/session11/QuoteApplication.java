package com.example.windykiss.session11;

import android.app.Application;

import com.example.windykiss.session11.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class QuoteApplication extends Application {
    @Override
    public void onCreate() {
        //cau hinh du thu o day
        super.onCreate();
        Preferences.init(this);
        intImageLoader();
    }

    private void intImageLoader() {
        //create config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        //add
        ImageLoader.getInstance().init(config);
    }
}
