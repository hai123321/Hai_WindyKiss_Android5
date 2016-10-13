package com.example.windykiss.session11.jsmodels;

/**
 * Created by WindyKiss on 10/12/2016.
 */

public class JSONModel2 {
    String date_taken;
    Media media;

    public JSONModel2(String date_taken, Media media) {
        this.date_taken = date_taken;
        this.media = media;
    }

    public String getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(String date_taken) {
        this.date_taken = date_taken;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public class Media{
        String m;

        public Media(String m) {
            this.m = m;
        }

        public String getM() {
            return m;
        }

        public void setM(String m) {
            this.m = m;
        }
    }
}
