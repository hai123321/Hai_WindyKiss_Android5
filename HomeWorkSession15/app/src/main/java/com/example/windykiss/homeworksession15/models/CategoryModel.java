package com.example.windykiss.homeworksession15.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/23/2016.
 */

public class CategoryModel {
    private String title;

    public CategoryModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static final List<CategoryModel> list = new ArrayList<>();
}
