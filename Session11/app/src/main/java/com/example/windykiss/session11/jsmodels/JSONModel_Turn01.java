package com.example.windykiss.session11.jsmodels;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class JSONModel_Turn01 {
    String userId;
    String title;
    String body;

    public JSONModel_Turn01(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
