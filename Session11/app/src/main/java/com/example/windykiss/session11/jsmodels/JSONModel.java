package com.example.windykiss.session11.jsmodels;

import java.util.ArrayList;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class JSONModel {
    private ArrayList<JSONModel2> items;


    public JSONModel(ArrayList<JSONModel2> items) {
        this.items = items;
    }

    public ArrayList<JSONModel2> getItems() {
        return items;
    }

    public void setItems(ArrayList<JSONModel2> items) {
        this.items = items;
    }
}
