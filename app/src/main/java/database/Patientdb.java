package database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pojos.Patient;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class Patientdb {

    private Patient patient;

    public Patientdb() {
        patient = new Patient();
    }

    public static String createTable(){

        String query = "CREATE TABLE "+Patient.TABLE+ "(patientid INTEGER PRIMARY KEY AUTOINCREMENT, firstName TEXT, lastName TEXT, department TEXT, doctorId INTEGER, room INTEGER )";
        return query;
    }

    public static int insert(Patient patient)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();

        values.put("firstName", patient.getFname());
        values.put("lastName", patient.getLname());
        values.put("department", patient.getDepartment());
        values.put("doctorId", patient.getDoctoId());
        values.put("room", patient.getRoomNo());

        id = (int)database.insert(Patient.TABLE, null, values);
        return id;
    }

    public static Patient getPatient(int patientid)
    {
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        Cursor cursor = null;
        try {

            String[] projection = {"firstName","lastName", "doctorId", "department", "room"};
            String where = "patientid = "+patientid;
            cursor = database.query(Patient.TABLE, projection, where, null, null, null, null);
            if(cursor.getCount()> 0)
            {
                cursor.moveToFirst();
                Patient patient = new Patient();
                patient.setPatientId(patientid);
                patient.setFname(cursor.getString(cursor.getColumnIndex("firstName")));
                patient.setLname(cursor.getString(cursor.getColumnIndex("lastName")));
                patient.setDepartment(cursor.getString(cursor.getColumnIndex("department")));
                patient.setRoomNo(cursor.getInt(cursor.getColumnIndex("room")));
                patient.setDoctoId(cursor.getInt(cursor.getColumnIndex("doctorId")));

                return patient;
            } else
                return null;

        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }finally {
            cursor.close();
        }
    }

    public static List<Patient> getAllPatients()
    {
        List<Patient> patientList = new ArrayList<Patient>();
        String query = "SELECT * FROM "+Patient.TABLE;
        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        Cursor cursor = database.rawQuery(query,null);

        try
        {
            while (cursor.moveToNext())
            {
                Patient patient = new Patient();
                patient.setPatientId(cursor.getInt(cursor.getColumnIndex("patientid")));
                patient.setFname(cursor.getString(cursor.getColumnIndex("firstName")));
                patient.setLname(cursor.getString(cursor.getColumnIndex("lastName")));

                patientList.add(patient);
            }
            return patientList;
        } catch (Exception e)
        {
            return null;
        }
    }
}
