package com.example.contact_tracking_zhiying;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contact_tracking_zhiying.databinding.ActivityPersonalBinding;

public class PersonalActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    TextView txt_name;
    TextView txt_phone;
    TextView txt_email;
    TextView txt_username;

    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Username = "usernameKey";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "phoneKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        //TextView ID for ProfileActivity
        txt_name = findViewById(R.id.fullname);
        txt_email = findViewById(R.id.email);
        txt_phone = findViewById(R.id.phone);
        txt_username = findViewById(R.id.username);

        sharedPreferences = getApplication().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        //check if the preference by the key "nameKey" exist
        if (sharedPreferences.contains(Name)) {
            txt_name.setText(sharedPreferences.getString(Name, ""));
        }
        //check if the preference by the key "emailKey" exist
        if (sharedPreferences.contains(Email)) {
            txt_email.setText(sharedPreferences.getString(Email, ""));
        }
        //check if the preference by the key "phoneKey" exist
        if (sharedPreferences.contains(Phone)) {
            txt_phone.setText(sharedPreferences.getString(Phone, ""));
        }
        //check if the preference by the key "usernameKey" exist
        if (sharedPreferences.contains(Username)) {
            txt_username.setText(sharedPreferences.getString(Username, ""));
        }
    }

    public void goToSettings(View view) {
        startActivity(new Intent(PersonalActivity.this, SettingsActivity.class));
    }
}