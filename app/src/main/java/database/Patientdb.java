package database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

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

        String query = "CREATE TABLE "+Patient.TABLE+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, patientid INTEGER, firstName TEXT, lastName TEXT, department TEXT, doctorId INTEGER, room INTEGER )";
        return query;
    }

    public static int insert(Patient patient)
    {
        int id;

        SQLiteDatabase database = DatabaseManager.getInstance().openDB();
        ContentValues values = new ContentValues();

        values.put("patientid", patient.getPatientId());
        values.put("firstName", patient.getFname());
        values.put("lastName", patient.getLname());
        values.put("department", patient.getDepartment());
        values.put("doctorId", patient.getDoctoId());
        values.put("room", patient.getRoomNo());

        id = (int)database.insert(Patient.TABLE, null, values);
        return id;
    }

}
