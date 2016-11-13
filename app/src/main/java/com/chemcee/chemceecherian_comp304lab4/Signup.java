package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

import database.Doctordb;
import database.Nursedb;
import pojos.Doctor;
import pojos.Nurse;

public class Signup extends AppCompatActivity {

    static final String nurse = "NURSE";
    static final String doctor = "DOCTOR";

    String firstName, lastName, password, confirmPassword, department, category;
    EditText etfirstName, etlastName, etPassword, etConfirmPassword;
    Spinner spinner;
    String[] departments;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        category = null;
        spinner = (Spinner)findViewById(R.id.spinner_departments);
        departments = getResources().getStringArray(R.array.departments);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,departments);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        etfirstName = (EditText)findViewById(R.id.editText_FirstName);
        etlastName = (EditText)findViewById(R.id.editText_LastName);
        etPassword = (EditText)findViewById(R.id.login_password);
        etConfirmPassword = (EditText)findViewById(R.id.confirmPassword);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup_category);

        int tempRadioBtnId = radioGroup.getCheckedRadioButtonId();
        category = ((RadioButton)findViewById(tempRadioBtnId)).getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup rdGroup, int checkedId)
            {
                int radioBtnId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)findViewById(radioBtnId);
                category = radioButton.getText().toString();
            }
        });

    }

    public void signUp(View view)
    {
        firstName = etfirstName.getText().toString();
        lastName = etlastName.getText().toString();
        password = etPassword.getText().toString();
        confirmPassword = etConfirmPassword.getText().toString();
        department = spinner.getSelectedItem().toString();

        if(firstName.isEmpty()&& firstName.length()<1)
        {
            etfirstName.setError("Required Field");
            return;
        }
        else if(lastName.isEmpty()&& lastName.length()<1)
        {
            etlastName.setError("Required Field");
            return;
        }
        else if(password.isEmpty()&& password.length()<1)
        {
            etPassword.setError("Required Field");
            return;
        }
        else if(!password.equals(confirmPassword))
        {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            etConfirmPassword.setError("Passwords do not match. Try again");
            return;
        }
        else {
            if(category.equalsIgnoreCase(nurse))
            {
                Nurse nurse = new Nurse();
                int id = (int)new Date().getTime();
                nurse.setDepartment(department);
                nurse.setFirstName(firstName);
                nurse.setLastName(lastName);
                nurse.setPassword(password);
                nurse.setNurseId(id);

                Nursedb nursedb = new Nursedb();
                nursedb.insert(nurse);

                Intent intent = new Intent(this, ConfirmSignUp.class);
                intent.putExtra("category", category);
                intent.putExtra("staff",nurse);
                startActivity(intent);
            } else if(category.equalsIgnoreCase(doctor))
            {
                Doctor doctor = new Doctor();
                int id = (int)new Date().getTime();
                doctor.setFirstName(firstName);
                doctor.setLastName(lastName);
                doctor.setPassword(password);
                doctor.setDepartment(department);
                doctor.setDoctorId(id);

                Doctordb doctordb = new Doctordb();
                doctordb.insert(doctor);

                Intent intent = new Intent(this, ConfirmSignUp.class);
                intent.putExtra("category", category);
                intent.putExtra("staff",doctor);
                startActivity(intent);
            }
        }
    }

    //back to login screen on press of cancel button
    public void cancel(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
