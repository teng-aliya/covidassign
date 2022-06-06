package com.example.contact_tracking_zhiying.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    String baseUrl = "https://61ad7ca7d228a9001703adf6.mockapi.io/";

    // on below line we are creating a retrofit
    // builder and passing our base url
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            // as we are sending data in json format so
            // we have to add Gson converter factory
            .addConverterFactory(GsonConverterFactory.create())
            // at last we are building our retrofit builder.
            .build();

    // below line is to create an instance for our retrofit api class.
    HistoryAPI retrofitAPI = retrofit.create(HistoryAPI.class);
}
