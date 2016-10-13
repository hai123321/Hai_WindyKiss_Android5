package com.example.windykiss.session11.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class Preferences {
    private static final String KEY = "Quote";
    private static final String USER_NAME_KEY = "username";
    private SharedPreferences sharedPreferences;
    public Preferences(Context context){
        // context can be activity or App
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public String getUserName() {
        return sharedPreferences.getString(USER_NAME_KEY, null);
    }

    public void putUserName( String userName){
        sharedPreferences.edit().putString(USER_NAME_KEY, userName).apply();
    }

    private static Preferences instance;
    public static Preferences getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new Preferences(context);
    }
}
