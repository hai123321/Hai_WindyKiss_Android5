package com.example.windykiss.homework15_0102.Services;

import com.example.windykiss.homework15_0102.models.LoginModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by WindyKiss on 11/4/2016.
 */

public interface Foo {
    @POST("/api/login")
    Call<LoginModel> postJson(@Body RequestBody body);
}
