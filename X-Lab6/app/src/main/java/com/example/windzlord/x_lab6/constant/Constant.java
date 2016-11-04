package com.example.windzlord.x_lab6.constant;

/**
 * Created by WindzLord on 10/12/2016.
 */

public class Constant {
    public static String[] CATEGORIES = {"buildings", "food", "nature", "people", "technology", "objects"};
    public static int SIZE_WIDTH = 600;
    public static int SIZE_HEIGHT = 800;
    public static String UNSPLASH_API = String.format("https://source.unsplash.com/category/%s/%dx%d",
            CATEGORIES[2], SIZE_WIDTH, SIZE_HEIGHT);

    public static String QUOTE_API = "http://quotesondesign.com/wp-json/";

    public static String PLACE = "http://jsonplaceholder.typicode.com/posts";

    public static String GIRL = "http://www.flickr.com/services/feeds/photos_public.gne?tags=girl&format=json&title=girl";
}
