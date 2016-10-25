package com.example.windykiss.homeworksession15.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/23/2016.
 */

public class BreakFastModel {
    private String title;
    private int imgID;

    public BreakFastModel(int imgID, String title) {
        this.imgID = imgID;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImgID() {
        return imgID;
    }

    public static final List<BreakFastModel> list = new ArrayList<>();
}
