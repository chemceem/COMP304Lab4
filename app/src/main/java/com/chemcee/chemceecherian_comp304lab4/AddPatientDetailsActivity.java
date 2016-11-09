package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pojos.Patient;


public class AddPatientDetailsActivity extends AppCompatActivity {

    private EditText editTextTmp;
    private Intent customerInent;
    private Patient newPatient;
    private String inputValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_details);
    }

    public void onSubmit(View view){
        if(validateInputs()){
            storePatientInfo();
            //customerInent = new Intent(this,checkOutActivity.class);
            //customerInent.putExtra("ourCustomer", newCustomer);
            //startActivity(customerInent);
            Toast.makeText(AddPatientDetailsActivity.this, "Details Added "+ newPatient.getFname(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AddPatientDetailsActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  Stores the patient data to the customer object
     */

    public void storePatientInfo(){

        editTextTmp = (EditText) findViewById(R.id.fnameEditTxt);
        newPatient.setFname(editTextTmp.getText().toString());

        editTextTmp = (EditText) findViewById(R.id.lnameEditTxt);
        newPatient.setLname(editTextTmp.getText().toString());

        editTextTmp = (EditText) findViewById(R.id.depEditTxt);
        newPatient.setDepartment(editTextTmp.getText().toString());

        editTextTmp = (EditText) findViewById(R.id.docEditTxt);
        newPatient.setDoctoId(Integer.parseInt( editTextTmp.getText().toString()));

        editTextTmp = (EditText) findViewById(R.id.roomEditTxt);
        newPatient.setRoomNo(Integer.parseInt(editTextTmp.getText().toString()));

        editTextTmp = (EditText) findViewById(R.id.tempEditTxt);
        newPatient.setTemperature(Integer.parseInt(editTextTmp.getText().toString()));

        editTextTmp = (EditText) findViewById(R.id.bplEditTxt);
        newPatient.setBplValue(Integer.parseInt(editTextTmp.getText().toString()));

        editTextTmp = (EditText) findViewById(R.id.bphEditTxt);
        newPatient.setBphValue(Integer.parseInt(editTextTmp.getText().toString()));
    }

    /**
     * Validates all the input fields of the customer information
     * @return
     */

    private boolean validateInputs(){
        boolean checkStatus = true;
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.fnameEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.lnameEditTxt));
        checkStatus = checkIfEmpty((EditText) findViewById(R.id.depEditTxt));
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
