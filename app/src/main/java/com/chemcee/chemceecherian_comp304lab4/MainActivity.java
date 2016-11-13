package com.chemcee.chemceecherian_comp304lab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import database.Doctordb;
import database.Nursedb;

public class MainActivity extends AppCompatActivity {

    String userid, password, category;
    EditText etUserid, etPassword;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signup = (TextView)findViewById(R.id.textView_RegisterHere);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        etUserid = (EditText)findViewById(R.id.editText_userid);
        etPassword = (EditText)findViewById(R.id.login_password);

        int tempRadioBtnId = radioGroup.getCheckedRadioButtonId();
        category = ((RadioButton)findViewById(tempRadioBtnId)).getText().toString();

        //on clicking, new user signup
        signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), Signup.class);
                startActivity(intent);
            }
        });

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

    public void Login(View view)
    {
        userid = etUserid.getText().toString();
        password = etPassword.getText().toString();

        if(userid.isEmpty()&& userid.length()<1)
        {
            etUserid.setError("Required Field");
            return;
        }
        else if(password.isEmpty()&& password.length()<1)
        {
            etPassword.setError("Required Field");
            return;
        }
        else {
            attemptLogin();
        }
    }

    public void attemptLogin(){

        boolean loginStatus = false;

        if(category.equalsIgnoreCase("Nurse"))
        {
            //checking authentication
            String name = Nursedb.authenticate(userid, password);

            if(name != null && !name.isEmpty())
                loginStatus = true;

            if(loginStatus)
            {
                Intent intent = new Intent(this, Nurse_Home.class);
                intent.putExtra("firstName", name);
                startActivity(intent);
            } else
            {
                Toast.makeText(MainActivity.this, "Invalid username/password", Toast.LENGTH_SHORT).show();
                return;
            }
        } else if(category.equalsIgnoreCase("doctor"))
        {
            //checking authentication
            String name = Doctordb.authenticate(userid, password);

            if(name != null && !name.isEmpty())
                loginStatus = true;

            if(loginStatus)
            {
                Intent intent = new Intent(this, Doctor_Home.class);
                intent.putExtra("firstName", name);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid username/password", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }


}
