package com.example.windzlord.x_lab6.models;

import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by WindzLord on 10/26/2016.
 */

public class Quote extends RealmObject {
    private int id;
    private String title;
    private String content;

    public Quote() {
    }


    public static Quote create(String title, String content) {
        Quote quote = new Quote();
        quote.id = -1;
        quote.title = title;
        quote.content = content;
        return quote;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %s", id, title, content);
    }
}
