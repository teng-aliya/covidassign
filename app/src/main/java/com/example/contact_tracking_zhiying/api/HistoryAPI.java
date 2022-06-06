package com.example.contact_tracking_zhiying.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// Retrofit API Declaration
public interface HistoryAPI {

    // API Declaration
    // https://square.github.io/retrofit/

    // as we are making a post request to post a data
    // so we are annotating it with post
    // and along with that we are passing a parameter as users
    @FormUrlEncoded
    @POST("addHistory.php")  //insert new data
    Call<History> addNewHistory(
            @Field("location") String location,
            @Field("date") String date,
            @Field("time") String time);

    @FormUrlEncoded
    @GET("getHistoryById.php")  // get one history item by ID
    Call<History> getHistory(@Field("id") int id);

    @GET("getHistories.php")  // get all history items
    Call<List<History>> getHistories();

    @FormUrlEncoded
    @HTTP(method = "PUT", path = "updateHistory.php", hasBody = true)
    Call<History> updateHistory(@Field("id") int id,
                                @Field("location") String location,
                                @Field("date") String date,
                                @Field("time") String time);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "deleteHistory.php", hasBody = true)
    Call<History> deleteHistory(@Field("id") int id);
}