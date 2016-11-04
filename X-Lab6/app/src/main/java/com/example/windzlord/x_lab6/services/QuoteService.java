package com.example.windzlord.x_lab6.services;

import com.example.windzlord.x_lab6.jsonmodels.QuoteJSONModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by WindyKiss on 11/2/2016.
 */

public interface QuoteService {
    @GET("posts?filter[orderby]=rand&filter[posts_per_page]=1")
    Call<List<QuoteJSONModel>> listRepos();
}
