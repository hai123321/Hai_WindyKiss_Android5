package com.example.windykiss.homeworksession15;

/**
 * Created by WindyKiss on 10/28/2016.
 */
public class TempNote {
    private int id;
    private String title;
    private String content;
    private String time_created;

    public TempNote(int id, String title, String content, String time_created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time_created = time_created;
    }

    public TempNote(String title, String content, String time_created){
        this(-1, title, content, time_created);
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

    public String getTime_created() {
        return time_created;
    }

    public void setID(int id) {
        this.id = id;
    }
}
