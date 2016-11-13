package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chemcee.chemceecherian_comp304lab4.application.App;
import pojos.Doctor;
import pojos.Nurse;
import pojos.Patient;
import pojos.Tests;

/**
 * Created by Chemcee. M. C on 10-11-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 8;
    private static final String DATABASE_NAME = "hospital.db";
    private final Context context;

    public DatabaseHelper(Context context)
    {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Nursedb.createTable());
        db.execSQL(Doctordb.createTable());
        db.execSQL(Patientdb.createTable());
        db.execSQL(Testsdb.create());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("DROP TABLE IF EXISTS " + Doctor.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Patient.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Tests.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Nurse.TABLE);
    }

}
