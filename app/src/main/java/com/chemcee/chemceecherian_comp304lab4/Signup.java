package com.chemcee.chemceecherian_comp304lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    String firstName, lastName, password, confirmPassword, department, category;
    EditText etfirstName, etlastName, etPasswowrd, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}
