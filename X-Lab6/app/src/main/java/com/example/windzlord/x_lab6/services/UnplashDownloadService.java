package com.example.windzlord.x_lab6.services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.CalendarContract;

import com.example.windzlord.x_lab6.constant.Constant;
import com.example.windzlord.x_lab6.managers.FileManager;
import com.example.windzlord.x_lab6.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by WindzLord on 10/23/2016.
 */

public class UnplashDownloadService extends IntentService {

    public UnplashDownloadService() {
        super("UnplashDownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            Bitmap bitmap = ImageLoader.getInstance().loadImageSync(Constant.UNSPLASH_API);
            if (bitmap == null) {
                i--;
                continue;
            }

            System.out.println("loading " + i);
            FileManager.getInstance().createImage(bitmap, i);

            Preferences.getInstance().putImageCount(i + 1);
        }
    }
}
