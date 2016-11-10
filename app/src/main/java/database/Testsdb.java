package database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import pojos.Tests;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Testsdb {

    private Tests tests;

    public Testsdb(){
        tests = new Tests();
    }

    public String create()
    {
        String query = "CREATE TABLE "+ Tests.TABLE +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,testId INTEGER,  patientId INTEGER, bpl INTEGER, bph INTEGER, temperature INTEGER)";
        return query;
    }

    public static int insert(Tests tests)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();

        values.put("testId", tests.getTestId());
        values.put("patientId", tests.getPatientId());
        values.put("bpl", tests.getBPL());
        values.put("bph", tests.getBPH());
        values.put("temperature", tests.getTemperature());

        id = (int)database.insert(Tests.TABLE, null, values);
        return id;
    }
}
