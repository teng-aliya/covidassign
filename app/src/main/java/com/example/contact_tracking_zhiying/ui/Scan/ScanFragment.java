package com.example.contact_tracking_zhiying.ui.Scan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contact_tracking_zhiying.HistoryActivity;
import com.example.contact_tracking_zhiying.R;
import com.example.contact_tracking_zhiying.SettingsActivity;
import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;

public class ScanFragment extends Fragment {

    SharedPreferences sharedPreferences;

    TextView text_name;
    TextView text_phone;

    public static final String mypreference = "com.example.contact_tracking_zhiying.userreg";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";

    Button btnScan;
    ImageView imgScan;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_scan, container, false);

        btnScan = root.findViewById(R.id.btn_scan);
        imgScan = root.findViewById(R.id.img_scan);

        text_name = root.findViewById(R.id.name);
        text_phone = root.findViewById(R.id.phoneno);

        sharedPreferences = getActivity().getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name)) {
            text_name.setText(sharedPreferences.getString(Name, ""));
        }

        if (sharedPreferences.contains(Phone)) {
            text_phone.setText(sharedPreferences.getString(Phone, ""));
        }

        //Scanning button listener
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ZXing library codes
                IntentIntegrator integrator;
                integrator = IntentIntegrator.forSupportFragment(ScanFragment.this);
                //set the properties of the scan
                //integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.setOrientationLocked(true);

                // initiate the scan action
                integrator.initiateScan();
            }
        });

        //Scanning button listener
        imgScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ZXing library codes
                IntentIntegrator integrator = IntentIntegrator.forSupportFragment(ScanFragment.this);
                //set the properties of the scan
                //integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.setOrientationLocked(true);

                // initiate the scan action
                integrator.initiateScan();
            }
        });

        ImageView history_button = (ImageView) root.findViewById(R.id.history_scan);
        history_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}