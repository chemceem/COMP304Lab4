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
        String query = "CREATE TABLE "+Nurse.TABLE+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, nurseId INTEGER,userName TEXT, firstName TEXT, lastName TEXT, department TEXT, password TEXT)";
        return  query;
    }

    public static int insert(Nurse nurse)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();
        values.put("nurseId", nurse.getNurseId());
        values.put("userName", nurse.getUserName());
        values.put("firstName", nurse.getFirstName());
        values.put("lastName", nurse.getLastName());
        values.put("department", nurse.getDepartment());
        values.put("password", nurse.getPassword());

        id = (int)database.insert(Nurse.TABLE, null, values);
        return id;
    }

    //check if username exists
    public static boolean checkUsername(String userName)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        String[] projection = {
                "userName"
        };

        String where = "userName = '"+userName.toLowerCase()+"'";
        Cursor cursor = database.query(Nurse.TABLE, projection, where, null, null, null, null);

        if (cursor.getCount()>0) { //if username exists
            cursor.moveToFirst();
            cursor.close();
            return true;
        }
        else{
            cursor.close();
            return false;
        }
    }

    //method to authenticate doctor
    public static String authenticate(String userName, String password)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        String[] projection = {
                "userName", "firstName"
        };

        String where = "userName = '"+userName+ "' and password = '"+password+"'";

        Cursor cursor = database.query(Nurse.TABLE, projection, where, null, null, null, null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
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
