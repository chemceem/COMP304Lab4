package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import database.Patientdb;
import database.Testsdb;
import pojos.Patient;
import pojos.Tests;


public class AddPatientDetailsActivity extends AppCompatActivity {

    private EditText editTextTmp;
    private Intent customerInent;
    private Patient newPatient;
    private String inputValue;
    private Tests test;
    Spinner spinner;
    String[] departments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_details);

        departments = getResources().getStringArray(R.array.departments);
        spinner = (Spinner)findViewById(R.id.spinner_dept);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,departments);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    public void onSubmit(View view){
        if(validateInputs()){
            storePatientInfo();
            //customerInent = new Intent(this,checkOutActivity.class);
            //customerInent.putExtra("ourCustomer", newCustomer);
            //startActivity(customerInent);
            Toast.makeText(AddPatientDetailsActivity.this, "Details Added "+ newPatient.getFname(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Nurse_Home.class);
            intent.putExtra("firstName", (String)getIntent().getExtras().getString("firstName"));
            startActivity(intent);
        }else{
            Toast.makeText(AddPatientDetailsActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  Stores the patient data to the customer object
     */

    public void storePatientInfo(){

        newPatient = new Patient();
        test = new Tests();

        editTextTmp = (EditText) findViewById(R.id.fnameEditTxt);
        newPatient.setFname(editTextTmp.getText().toString());

        editTextTmp = (EditText) findViewById(R.id.lnameEditTxt);
        newPatient.setLname(editTextTmp.getText().toString());

        newPatient.setDepartment(spinner.getSelectedItem().toString());

        editTextTmp = (EditText) findViewById(R.id.docEditTxt);
        newPatient.setDoctoId(Integer.parseInt( editTextTmp.getText().toString()));

        editTextTmp = (EditText) findViewById(R.id.roomEditTxt);
        newPatient.setRoomNo(Integer.parseInt(editTextTmp.getText().toString()));

        int id = Patientdb.insert(newPatient);

        //getting the test data
        editTextTmp = (EditText)findViewById(R.id.tempEditTxt);
        test.setTemperature(Float.parseFloat(editTextTmp.getText().toString()));

        editTextTmp = (EditText)findViewById(R.id.bplEditTxt);
        test.setBPL(Float.parseFloat(editTextTmp.getText().toString()));

        editTextTmp = (EditText)findViewById(R.id.bphEditTxt);
        test.setBPH(Float.parseFloat(editTextTmp.getText().toString()));

        test.setPatientId(id);

        Testsdb.insert(test);

    }

    /**
     * Validates all the input fields of the customer information
     * @return
     */

    private boolean validateInputs(){
        boolean checkStatus = true;
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.fnameEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.lnameEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.docEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.roomEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.tempEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.bplEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.bphEditTxt));

        return checkStatus;
    }

    /**
     * Generic method to check if the editText passed is empty or not
     * @param editTextTmp
     * @return
     */

    private boolean checkIfEmpty(EditText editTextTmp){
        boolean checkStatus = true;
        inputValue = editTextTmp.getText().toString();
        if(inputValue.trim().length() == 0){
            checkStatus = false;
            editTextTmp.setError("required");
        }
        return checkStatus;
    }

}
