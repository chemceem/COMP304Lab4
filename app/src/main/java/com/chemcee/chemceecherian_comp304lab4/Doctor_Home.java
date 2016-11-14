package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import database.Patientdb;
import database.Testsdb;
import pojos.Patient;
import pojos.Tests;

public class Doctor_Home extends AppCompatActivity {

    String name;
    int patientId;
    TextView firstName;
    EditText editText, etPatientId;
    Patient patient;
    Tests test;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__home);

        etPatientId = (EditText)findViewById(R.id.et_patientId);
        firstName = (TextView)findViewById(R.id.tv_hellofirstName);
        name = (String)getIntent().getExtras().getString("firstName");

        firstName.setText(" "+name);
        scrollView = (ScrollView)findViewById(R.id.scrollView_PatientDetails);
        scrollView.setVisibility(View.INVISIBLE);
    }

    public void searchPatient(View view)
    {
        if(etPatientId.getText().length() < 1) {
            etPatientId.setError("Enter patiend id.");
            return;
        } else {
            scrollView.setVisibility(View.VISIBLE);
            TextView textView;
            test = new Tests();

            patientId = Integer.parseInt(etPatientId.getText().toString());

            //search for patient details in the database
            patient = Patientdb.getPatient(patientId);
            if(patient != null)
            {
                test = Testsdb.getTest(patientId);
                textView = (TextView)findViewById(R.id.textView_PatientName);
                textView.setText(patient.getFname()+" "+patient.getLname());

                textView = (TextView)findViewById(R.id.textView_PatientId);
                textView.setText(String.valueOf(patient.getPatientId()));

                if(test != null) //if test returns null
                {
                    editText = (EditText)findViewById(R.id.editText_doctor_BPH);
                    editText.setText(String.valueOf(test.getBPH()));

                    editText = (EditText)findViewById(R.id.editText_doctor_BPL);
                    editText.setText(String.valueOf(test.getBPL()));

                    editText = (EditText)findViewById(R.id.editText_doctor_Temperature);
                    editText.setText(String.valueOf(test.getTemperature()));
                } else
                {
                    editText = (EditText)findViewById(R.id.editText_doctor_BPH);
                    editText.setText("0.0");

                    editText = (EditText)findViewById(R.id.editText_doctor_BPH);
                    editText.setText("0.0");

                    editText = (EditText)findViewById(R.id.editText_doctor_Temperature);
                    editText.setText("0.0");
                }

            } else {
                scrollView.setVisibility(View.INVISIBLE);
                Toast.makeText(Doctor_Home.this, "Patient id not found.", Toast.LENGTH_LONG).show();
            }
        }
    }

    //method to update details of a patient
    public void updatePatientDetails(View view)
    {
        float newBph,newBpl, newTemp;
        EditText editedValues;

        editedValues = (EditText)findViewById(R.id.editText_doctor_Temperature);
        newTemp = Float.parseFloat(editedValues.getText().toString());

        editedValues = (EditText)findViewById(R.id.editText_doctor_BPH);
        newBph = Float.parseFloat(editedValues.getText().toString());

        editedValues = (EditText)findViewById(R.id.editText_doctor_BPL);
        newBpl = Float.parseFloat(editedValues.getText().toString());

        Tests testEdited = new Tests();
        testEdited.setTemperature(newTemp);
        testEdited.setBPL(newBpl);
        testEdited.setBPH(newBph);
        testEdited.setPatientId(patientId);

        int status = Testsdb.updateTests(patientId, testEdited);
        if(status > 0)
        {
            Toast.makeText(Doctor_Home.this, "Patient data updated.", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(Doctor_Home.this, "ERROR. Contact Admin", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view)
    {
        etPatientId.setText("");
        scrollView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
