package com.example.windzlord.x_lab6.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.windzlord.x_lab6.models.Quote;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindzLord on 10/26/2016.
 */

public class DBHelper extends SQLiteAssetHelper {

    private final static String DB_NAME = "demo.db";
    private final static int DB_VERSION = 1;
    private static final String QUOTE_TABLE_NAME = "tbl_quote";
    private static final String QUOTE_COLUMN_ID = "ID";
    private static final String QUOTE_COLUMN_TITLE = "title";
    private static final String QUOTE_COLUMN_CONTENT = "content";
    private static final String[] QUOTE_COLUMNS = new String[]{
           QUOTE_COLUMN_ID,
            QUOTE_COLUMN_TITLE,
            QUOTE_COLUMN_CONTENT
    };

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insert(Quote quote) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE, quote.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT, quote.getContent());
        long id = writableDatabase.insert(QUOTE_TABLE_NAME, null, contentValues);
        quote.setID((int)id);
        writableDatabase.close();
    }


    public List<Quote> selectAllQuote(){
        ArrayList<Quote> quotesList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

//    public Cursor query(String table, String[] columns, String selection,
//                        String[] selectionArgs, String groupBy, String having,
//                        String orderBy) {

        Cursor cursor = db.query(QUOTE_TABLE_NAME,
                QUOTE_COLUMNS,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()){
            quotesList.add(createQuote(cursor));
        }
        cursor.close();

        db.close();
        return quotesList;
    }

    public void deleteAllQuote(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
          QUOTE_TABLE_NAME,
                null,
                null
        );
    }



    private Quote createQuote(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(QUOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_CONTENT));
        return new Quote(id,title,content);
    }

    public Quote getRandomQuote(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(QUOTE_TABLE_NAME,//table
                QUOTE_COLUMNS,//column
                null,//selection
                null,//selectionArgs
                null,//groupBy
                null,//having
                "RANDOM()",//orderBy
                "1");//limit

        if(cursor.moveToNext()){
            return createQuote(cursor);
        }
        return null;
    }

    public static DBHelper instance;

    public static DBHelper getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new DBHelper(context);
    }

    public void delete(Quote quote) {
        //delete by ID
        SQLiteDatabase db = getWritableDatabase();
        db.delete(
          QUOTE_TABLE_NAME,
                QUOTE_COLUMN_ID +"="+quote.getId(),
                null
        );
    }
}
