package com.example.contact_tracking_zhiying;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.example.contact_tracking_zhiying.ui.Profile.ProfileFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void goBack(View view){
        startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
    }
    public void goToPassword(View view) {
        startActivity(new Intent(SettingsActivity.this,ChangePasswordActivity.class));
    }
    public void goToPersonal(View view) {
        startActivity(new Intent(SettingsActivity.this,PersonalActivity.class));
    }
    public void goToLogin(View view) {
        startActivity(new Intent(SettingsActivity.this,LoginActivity.class));
    }
}