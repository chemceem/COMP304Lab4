package com.chemcee.chemceecherian_comp304lab4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Doctor_Home extends AppCompatActivity {

    String name;
    TextView firstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__home);

        firstName = (TextView)findViewById(R.id.tv_hellofirstName);
        name = (String)getIntent().getExtras().getString("firstName");

        firstName.setText(" "+name);
    }
}
