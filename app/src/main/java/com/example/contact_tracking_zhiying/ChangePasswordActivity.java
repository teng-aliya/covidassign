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

public class ChangePasswordActivity extends AppCompatActivity {
    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Password = "passwordKey";

    SharedPreferences sharedpreferences;

    EditText old_pass;
    EditText new_pass;
    EditText confirm_pass;
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        bt_submit = findViewById(R.id.pass_submit);
        bt_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //Authentication flow
                old_pass = findViewById(R.id.et_opass);
                new_pass = findViewById(R.id.et_npass);
                confirm_pass = findViewById(R.id.et_cpass);

                // Retrieve values from shared preference
                sharedpreferences = getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                if (sharedpreferences.contains(Password)) {
                    // Username (email) and password are the same as stored in shared preference
                    /*
                    email entered = email stored in SF
                    AND
                    password entered = password stored in SF
                    */
                    if ((old_pass.getText().toString().equals(sharedpreferences.getString(Password, ""))) &&
                            (new_pass.getText().toString().equals(confirm_pass.getText().toString()))) {
                        // If the cookie for active session is not created yet
                        String password = new_pass.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(Password, password);
                        editor.commit();


                        //Change Password successful
                        String message = "Password succesfully changed";
                        int duration = Snackbar.LENGTH_SHORT;
                        Snackbar.make(v, message, duration).show();


                    } else {
                        //Login fail use Toast or Snackbar

                        String message = "Password failed to register";
                        int duration = Snackbar.LENGTH_SHORT;
                        Snackbar.make(v, message, duration).show();

                    }

                }
            }
        });
    }

    public void goToSettings(View view) {
        startActivity(new Intent(ChangePasswordActivity.this, SettingsActivity.class));
    }
}