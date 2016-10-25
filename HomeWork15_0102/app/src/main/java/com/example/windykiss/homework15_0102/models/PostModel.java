package com.example.windykiss.homework15_0102.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class PostModel {
    private String title;
    private String content;

    public PostModel(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public static final List<PostModel> list = new ArrayList<>();
}
