package com.example.windykiss.lab01_sesson06;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class ListItem {
    String title;
    String detail;
    int imgageID;

    public ListItem(String title, String detail, int imgageID) {
        this.title = title;
        this.detail = detail;
        this.imgageID = imgageID;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getImgageID() {
        return imgageID;
    }

    public void setImgageID(int imgageID) {
        this.imgageID = imgageID;
    }

    public static final ListItem[] ARRAY = new ListItem[]{
            new ListItem("He may act like he wants a secretary but most of the time they’re looking for…", "10m", R.drawable.item1),
            new ListItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face", "11m", R.drawable.item2),
            new ListItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head", "12m", R.drawable.item3),
            new ListItem("Get out of here and move forward. This never happened. It will shock you how much", "13m", R.drawable.item4),
            new ListItem("That poor girl. She doesn’t know that loving you is the worst way to get you", "14m", R.drawable.item5)
    };

    @Override
    public String toString() {
        return this.title;
    }
}
