package com.chemcee.chemceecherian_comp304lab4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.Patientdb;
import pojos.Patient;

/**
 * sa
 */
public class ViewPatientsList_Nurse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patients_list__nurse);

        fetchAllPatients();
    }

    public void fetchAllPatients()
    {
        List<Patient> patients = new ArrayList<Patient>();
        try
        {
            patients = Patientdb.getAllPatients();
            displayPatients(patients);
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(ViewPatientsList_Nurse.this, "Error fetching patients. Contact Administrator", Toast.LENGTH_LONG).show();
        }
    }

    public void displayPatients(List<Patient> patientList)
    {
        TextView textView;
        TableLayout tableLayout_PatientList = (TableLayout)findViewById(R.id.tableLayout_PatientList);
        TableLayout.LayoutParams tableLayoutParams=  new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
        tableLayoutParams.setMargins(15, 15, 15, 15);
        for(final Patient patient : patientList)
        {
            TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
            tableRowParams.setMargins(10, 10, 10, 10);

            //TableRow.LayoutParams tableRowParamsRight = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);

            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(tableLayoutParams);

            textView = new TextView(this);
            textView.setText("Name:  "+patient.getFname()+" "+patient.getLname()+" ("+String.valueOf(patient.getPatientId())+")");
            textView.setLayoutParams(tableRowParams);

            tableRow.addView(textView);
            tableLayout_PatientList.addView(tableRow);

            textView.setOnClickListener(new TextView.OnClickListener(){

                public void onClick(View view)
                {
                    Toast.makeText(ViewPatientsList_Nurse.this, patient.getFname(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
