package com.example.windykiss.homework15_0102;
import com.google.gson.annotations.SerializedName;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class LoginPostJsonModel {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public LoginPostJsonModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}