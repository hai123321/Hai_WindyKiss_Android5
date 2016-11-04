package com.example.windzlord.x_lab6.managers;

import android.content.Context;

import com.example.windzlord.x_lab6.models.Quote;

import java.util.List;
import java.util.Random;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by WindyKiss on 11/2/2016.
 */

public class DBContext {
    private Realm realm;

    public DBContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    private static DBContext instance;

    public static DBContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new DBContext(context);
        }
    }

    public void add(Quote quote) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealm(quote);
        realm.commitTransaction();
    }

    public List<Quote> findAllQuote() {
        Realm realm = Realm.getDefaultInstance();
        //3Query

        RealmResults<Quote> quotes = realm
                .where(Quote.class)
                .findAll();
        return quotes;
    }

    public Quote findByName(int id) {
        Realm realm = Realm.getDefaultInstance();
        //3Query

        Quote person = realm
                .where(Quote.class)
                .equalTo("id", id + "", Case.INSENSITIVE)
                .findFirst();
        //.findFirst to find 1st person.
        return person;
    }

    public Quote findRandom() {
        List<Quote> all = findAllQuote();
        Random in = new Random();
        return all.get(in.nextInt(all.size()));
    }

//    public void update(Quote p, String toName, int toAge){
//        beginTransaction();
//        p.setAge(toAge);
//        p.setName(toName);
//        commitTransaction();
//    }
//
//    public void delete(Person p){
//        beginTransaction();
//        p.deleteFromRealm();
//        commitTransaction();
//    }

    public void beginTransaction() {
        Realm.getDefaultInstance().beginTransaction();
    }

    public void commitTransaction() {
        Realm.getDefaultInstance().commitTransaction();
    }

    public void deleteAll(Class<? extends RealmModel> clazz) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(clazz);
        commitTransaction();
    }

    public int getNextKey()
    {
        return realm.where(Quote.class).max("id").intValue() + 1;
    }
}
