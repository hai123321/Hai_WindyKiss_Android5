package com.example.windzlord.x_lab6.models;

/**
 * Created by WindzLord on 10/26/2016.
 */

public class Quote {
    private int id;
    private String title;
    private String content;

    public Quote(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote(String title, String content) {
        this(-1, title, content);
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
