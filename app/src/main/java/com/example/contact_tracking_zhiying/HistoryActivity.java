package com.example.contact_tracking_zhiying;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.contact_tracking_zhiying.api.History;
import com.example.contact_tracking_zhiying.api.HistoryAPI;
import com.example.contact_tracking_zhiying.api.HistoryListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity extends AppCompatActivity {

    String responseString;
    RecyclerView recyclerView;
    HistoryListAdapter adapter;
    // local array list to keep the history list passed back by response
    List<History> historyList = new ArrayList<History>();
    ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        loadingPB = findViewById(R.id.idPB);

        // Set up recycler view.
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new HistoryListAdapter(new HistoryListAdapter.HistoryDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));

        // @GET("history") and list the History items
        retrieveHistoryFromApi();
    }

    // Retrofit GET
    private void retrieveHistoryFromApi() {
        String baseUrl = "https://6187cee1057b9b00177f9ab8.mockapi.io/";;

        // Retrofit code to retrieve data from database
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                // as we are sending data in json format so
                // we have to add Gson converter factory
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();

        // below line is to create an instance for our retrofit api class.
        HistoryAPI retrofitAPI = retrofit.create(HistoryAPI.class);

        Call<List<History>> call = retrofitAPI.getHistories();

        call.enqueue(new Callback<List<History>>() {
            @Override
            public void onResponse(Call<List<History>> call, Response<List<History>> response) {

                loadingPB.setVisibility(View.GONE); // make progressbar invisible
                recyclerView.setVisibility(View.VISIBLE); // make recyclerview visible

                if(response.isSuccessful()){
                    historyList = response.body();
                    // show the historyList values on the recyclerview
                    adapter.submitList(historyList);
                }
            }

            @Override
            public void onFailure(Call<List<History>> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, "Fail to get the data.." + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    } // end of retrieveHistoryFromAPI
}

