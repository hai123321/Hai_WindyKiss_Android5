package com.example.windykiss.homework15_0102;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class PostJSONModel {
    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;

    public PostJSONModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}