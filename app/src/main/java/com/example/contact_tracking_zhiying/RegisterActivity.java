package com.example.contact_tracking_zhiying;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity{

    Button go;

    EditText Sname;
    EditText Susername;
    EditText Semail;
    EditText Sphone;
    EditText Spassword;

    //For Shared Preference Set Up
    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Name = "nameKey";
    public static final String Username = "usernameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "phoneKey";
    public static final String Password = "passwordKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        go = findViewById(R.id.go);

        Sname = (TextInputEditText)findViewById(R.id.e_fname);
        Susername = (TextInputEditText)findViewById(R.id.e_username);
        Semail = (TextInputEditText)findViewById(R.id.e_email);
        Sphone = (TextInputEditText)findViewById(R.id.e_phone);
        Spassword = (TextInputEditText)findViewById(R.id.e_password);

        // Onclick listener for go button
        go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String name = Sname.getText().toString();
                String username = Susername.getText().toString();
                String email = Semail.getText().toString();
                String phone = Sphone.getText().toString();
                String password = Spassword.getText().toString();

                SharedPreferences sharedPref = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(Name,  name); //store string into the shared preference with nameKey
                editor.putString(Username, username); //store string into the shared preference with emailKey
                editor.putString(Email, email);
                editor.putString(Phone, phone);
                editor.putString(Password, password);
                editor.commit();

                //Redirect to login
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

            }
        });
    }

    public void goToLoginPage(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }
}