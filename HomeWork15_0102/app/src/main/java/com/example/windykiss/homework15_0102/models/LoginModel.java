package com.example.windykiss.homework15_0102.models;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class LoginModel {
    private String code;
    private String message;

    public LoginModel(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
