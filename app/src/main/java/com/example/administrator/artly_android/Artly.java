package com.example.administrator.artly_android;

import org.json.JSONStringer;

import java.util.HashMap;
import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017-08-09.
 */

public interface Artly {
    @GET("/api/user")
    Call<List<User>> login();

    @POST("/api/user.json")
    Call<User> createUser(@Body User user);

}
