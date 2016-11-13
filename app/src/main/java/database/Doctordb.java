package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pojos.Doctor;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Doctordb {

    private Doctor doctor;

    public Doctordb() {
        doctor = new Doctor();
    }

    //creating the table
    public static String createTable(){

        String query = "CREATE TABLE "+Doctor.TABLE +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,doctorId INTEGER,  firstName TEXT, lastName TEXT, department TEXT, password TEXT)";

        return query;
    }

    //inserting record into the table
    public static int insert(Doctor doctor)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();
        values.put("doctorId", doctor.getDoctorId());
        values.put("firstName", doctor.getFirstName());
        values.put("lastName", doctor.getLastName());
        values.put("department", doctor.getDepartment());
        values.put("password", doctor.getPassword());

        id = (int)database.insert(Doctor.TABLE, null, values);
        DatabaseManager.getInstance().closeDB();
        return id;
    }

    //method to authenticate doctor
    public static String authenticate(String doctorid, String password)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        String[] projection = {
                "doctorId", "firstName"
        };

        String where = "doctorId = "+doctorid+ " and password = '"+password+"'";

        Cursor cursor = database.query(Doctor.TABLE, projection, where, null, null, null, null);

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
