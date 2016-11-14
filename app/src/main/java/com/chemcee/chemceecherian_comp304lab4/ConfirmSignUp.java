package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pojos.Doctor;
import pojos.Nurse;

public class ConfirmSignUp extends AppCompatActivity {

    String category;
    Nurse nurse = null;
    Doctor doctor = null;
    TextView fname, lname, userid, department, staff, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_sign_up);

        category = (String)getIntent().getExtras().getString("category");
        staff = (TextView) findViewById(R.id.tv_staff);
        fname = (TextView) findViewById(R.id.tv_fname);
        lname = (TextView) findViewById(R.id.tv_lname);
        department = (TextView) findViewById(R.id.tv_dept);
        userid = (TextView) findViewById(R.id.tv_userid);
        userName = (TextView) findViewById(R.id.tv_username);

        if(category.equalsIgnoreCase("nurse"))          //if a nurse has signed up
        {
            nurse = (Nurse)getIntent().getSerializableExtra("staff");
            staff.setText(category);
            userName.setText(nurse.getUserName());
            userid.setText(String.valueOf(nurse.getNurseId()));
            fname.setText(nurse.getFirstName().toString());
            lname.setText(nurse.getLastName().toString());
            department.setText(nurse.getDepartment().toString());

        } else if(category.equalsIgnoreCase("doctor"))      //if a doctor has signed up
        {
            doctor = (Doctor)getIntent().getSerializableExtra("staff");
            staff.setText(category);
            userName.setText(doctor.getUserName());
            userid.setText(String.valueOf(doctor.getDoctorId()));
            fname.setText(doctor.getFirstName());
            lname.setText(doctor.getLastName());
            department.setText(doctor.getDepartment());
        }
    }

    public void goLogin(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
