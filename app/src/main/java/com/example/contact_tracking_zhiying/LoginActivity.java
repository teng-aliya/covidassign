package com.example.contact_tracking_zhiying;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Username = "usernameKey";
    public static final String Password = "passwordKey";
    public static final String Active = "loginKey";

    SharedPreferences sharedpreferences;

    EditText et_username;
    EditText et_password;
    Button bt_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_submit = findViewById(R.id.bt_submit);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Authentication flow
                et_username = findViewById(R.id.et_username);
                et_password = findViewById(R.id.et_password);

                // Retrieve values from shared preference
                sharedpreferences = getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains(Username) && sharedpreferences.contains(Password)) {
                    // Username (email) and password are the same as stored in shared preference
                    /*
                    email entered = email stored in SF
                    AND
                    password entered = password stored in SF
                    */
                    if ((et_username.getText().toString().equals(sharedpreferences.getString(Username, ""))) &&
                            (et_password.getText().toString().equals(sharedpreferences.getString(Password, "")))) {
                        // If the cookie for active session is not created yet
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putInt(Active, 1);
                        editor.commit();

                        //Login successful
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                    } else {
                        //Login fail use Toast or Snackbar
                        //Toast.makeText(LoginActivity.this,"Username / Password failed. Please try again.",Toast.LENGTH_SHORT).show();

                        String message = "Username / Password failed. Please try again.";
                        int duration = Snackbar.LENGTH_SHORT;
                        Snackbar.make(v, message, duration).show();

                    }

                } else {
                    //error message use Toast or Snackbar

                    String message = "Username / Password is not recognized. Please try again.";
                    int duration = Snackbar.LENGTH_SHORT;
                    Snackbar.make(v, message, duration).show();
                }

            }

        });
    }

    public void goToRegister(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
