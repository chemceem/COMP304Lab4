package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pojos.Nurse;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Nursedb
{

    private Nurse nurse;

    public Nursedb(){
      nurse = new Nurse();
    }

    //creating the table
    public static String createTable()
    {
        String query = "CREATE TABLE "+Nurse.TABLE+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, nurseId INTEGER, firstName TEXT, lastName TEXT, department TEXT, password TEXT)";
        return  query;
    }

    public static int insert(Nurse nurse)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();
        values.put("nurseId", nurse.getNurseId());
        values.put("firstName", nurse.getFirstName());
        values.put("lastName", nurse.getLastName());
        values.put("department", nurse.getDepartment());
        values.put("password", nurse.getPassword());

        id = (int)database.insert(Nurse.TABLE, null, values);
        return id;
    }

    //method to authenticate doctor
    public static String authenticate(String nurseid, String password)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        String[] projection = {
                "nurseId", "firstName"
        };

        String where = "nurseId = "+nurseid+ " and password = '"+password+"'";

        Cursor cursor = database.query(Nurse.TABLE, projection, where, null, null, null, null);

        if (cursor.moveToFirst()) {
            String value = cursor.getString(cursor.getColumnIndex("firstName"));
            cursor.close();
            return value;
        }
        else{
            cursor.close();
            return null;
        }
    }



}
