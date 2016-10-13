package com.example.windykiss.session11.jsmodels;

import java.util.ArrayList;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class ListTurn02 {
    private String date_taken;
    private String m;

    public ListTurn02(String date_taken, String m) {
        this.date_taken = date_taken;
        this.m = m;
    }

    public String getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(String date_taken) {
        this.date_taken = date_taken;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
}
