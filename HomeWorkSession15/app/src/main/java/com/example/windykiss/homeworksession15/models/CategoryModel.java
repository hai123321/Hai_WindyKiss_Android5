package com.example.windykiss.homeworksession15.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/23/2016.
 */

public class CategoryModel {
    private String title;
    private int imgID;

    public CategoryModel(int imgID, String title) {
        this.imgID = imgID;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImgID() {
        return imgID;
    }

    public static final List<CategoryModel> list = new ArrayList<>();
}
