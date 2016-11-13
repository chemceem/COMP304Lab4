package com.chemcee.chemceecherian_comp304lab4.application;

import android.app.Application;
import android.content.Context;

import database.DatabaseHelper;
import database.DatabaseManager;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class App extends Application {

    private static Context context;
    private static DatabaseHelper databaseHelper;

    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this.getApplicationContext();
        databaseHelper = new DatabaseHelper(this.getApplicationContext());
        DatabaseManager.initializedInstance(databaseHelper);
    }

    public static Context getContext()
    {
        return context;
    }
}
