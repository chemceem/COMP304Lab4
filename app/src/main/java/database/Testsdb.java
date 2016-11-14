package database;

import android.content.ContentValues;
import android.database.Cursor;
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

    public static String create()
    {
        String query = "CREATE TABLE "+ Tests.TABLE +
                "(testId INTEGER PRIMARY KEY AUTOINCREMENT, patientId INTEGER, bpl REAL, bph REAL, temperature REAL)";
        return query;
    }

    public static int insert(Tests tests)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();

        values.put("patientId", tests.getPatientId());
        values.put("bpl", tests.getBPL());
        values.put("bph", tests.getBPH());
        values.put("temperature", tests.getTemperature());

        id = (int)database.insert(Tests.TABLE, null, values);
        DatabaseManager.getInstance().closeDB();

        return id;
    }

    public static int updateTests(int patientid, Tests test)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();
        int status = 1;

        try{
            values.put("bpl", test.getBPL());
            values.put("bph", test.getBPH());
            values.put("temperature", test.getTemperature());

            database.update(Tests.TABLE, values,"patientId="+patientid,null);

            return status;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


    public static Tests getTest(int patientid)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        Cursor cursor = null;

        try{
            String[] projection = {"patientId","testId", "bpl", "bph", "temperature"};
            String where = "patientId = "+patientid;
            cursor = database.query(Tests.TABLE, projection,where, null, null, null,null);

            if(cursor.getCount()>0)
            {
                cursor.moveToFirst();
                Tests test = new Tests();
                test.setPatientId(patientid);
                test.setTestId(cursor.getInt(cursor.getColumnIndex("testId")));
                test.setBPL(cursor.getFloat(cursor.getColumnIndex("bpl")));
                test.setBPH(cursor.getFloat(cursor.getColumnIndex("bph")));
                test.setTemperature(cursor.getFloat(cursor.getColumnIndex("temperature")));

                return test;
            }
            else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            cursor.close();
        }
    }
}
