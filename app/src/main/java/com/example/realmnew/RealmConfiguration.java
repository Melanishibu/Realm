package com.example.realmnew;

import android.app.Application;

import io.realm.Realm;

public class RealmConfiguration extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        io.realm.RealmConfiguration config = new io.realm.RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(config);




    }
}