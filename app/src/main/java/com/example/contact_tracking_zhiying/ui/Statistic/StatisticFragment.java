package com.example.contact_tracking_zhiying.ui.Statistic;

import static com.example.contact_tracking_zhiying.R.id.confirm_text;

import
        android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.contact_tracking_zhiying.R;

import org.json.JSONException;
import org.json.JSONObject;

public class StatisticFragment extends Fragment {

    TextView tvCases, tvRecovered, tvActive, tvTotalDeaths;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_statistic, container, false);

        // Link those objects with their respective id's
        // that we have given in .XML file
        tvCases
                = root.findViewById(R.id.confirm_text);
        tvRecovered
                = root.findViewById(R.id.recover_text);
        tvActive
                = root.findViewById(R.id.active_text);
        tvTotalDeaths
                = root.findViewById(R.id.death_text);

        // Creating a method to fetch data using Volley
        fetchAPIUsingVolley();

        return root;
    }

    private void fetchAPIUsingVolley() {
        // Instantiate the Volley RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(this.getActivity());

        String url = "https://disease.sh/v3/covid-19/all";

        // https://developer.android.com/training/volley/simple
        // Request a string response from the provided URL.
        StringRequest request = new StringRequest(
                Request.Method.GET,  //parameter 1
                url,                 //parameter 2
                new Response.Listener<String>() {  //parameter 3
                    @Override
                    public void onResponse(String response) {
                        // We are going to process the response string here

                        try {
                            // Creating object of JSONObject
                            // https://developer.android.com/reference/org/json/JSONObject
                            // https://www.tutorialspoint.com/android/android_json_parser.htm
                            // https://www.journaldev.com/10642/android-jsonobject-json-parsing
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvCases.setText(
                                    jsonObject.getString(
                                            "cases"));
                            tvRecovered.setText(
                                    jsonObject.getString(
                                            "recovered"));
                            tvActive.setText(
                                    jsonObject.getString(
                                            "active"));
                            tvTotalDeaths.setText(
                                    jsonObject.getString(
                                            "deaths"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },new Response.ErrorListener() {  //parameter 4
            @Override
            public void onErrorResponse(VolleyError error) {
                // Print error message
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // Add the request to the RequestQueue.
        requestQueue.add(request);
    }
}