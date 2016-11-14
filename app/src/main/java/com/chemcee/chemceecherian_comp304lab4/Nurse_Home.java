package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Nurse_Home extends AppCompatActivity {

    String name;
    TextView firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse__home);

        firstName = (TextView)findViewById(R.id.tv_hellofirstNameNurse);
        name = (String)getIntent().getExtras().getString("firstName");
        firstName.setText(" "+name);
    }

    public void newPatient(View view)
    {
        Intent intent = new Intent(this, AddPatientDetailsActivity.class);
        intent.putExtra("firstName", name);
        startActivity(intent);
    }

    public void viewPatients(View view)
    {
        Intent intent = new Intent(this, ViewPatientsList_Nurse.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
