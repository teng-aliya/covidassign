package com.example.contact_tracking_zhiying.ui.Profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.contact_tracking_zhiying.R;
import com.example.contact_tracking_zhiying.SettingsActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {


    //Set up for sharedPreferences
    SharedPreferences sharedPreferences;

    TextView text_name;
    TextView text_phone;
    TextView text_email;
    TextView text_username;

    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Username = "usernameKey";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "phoneKey";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //TextView ID for ProfileFragment
        text_name = v.findViewById(R.id.profile_name);
        text_email = v.findViewById(R.id.email_name);
        text_phone = v.findViewById(R.id.phone_num);
        text_username = v.findViewById(R.id.username_user);

        sharedPreferences = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        //check if the preference by the key "nameKey" exist
        if (sharedPreferences.contains(Name)) {
            text_name.setText(sharedPreferences.getString(Name, ""));
        }
        //check if the preference by the key "emailKey" exist
        if (sharedPreferences.contains(Email)) {
            text_email.setText(sharedPreferences.getString(Email, ""));
        }

        if (sharedPreferences.contains(Phone)) {
            text_phone.setText(sharedPreferences.getString(Phone, ""));
        }

        if (sharedPreferences.contains(Username)) {
            text_username.setText(sharedPreferences.getString(Username, ""));
        }

        Button setting_button = (Button) v.findViewById(R.id.settings_button);
        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}