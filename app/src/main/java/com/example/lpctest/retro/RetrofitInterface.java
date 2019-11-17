package com.example.lpctest.retro;


import com.example.lpctest.Entities.Pot;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @GET("get-pots")
    public Call<List<Pot>> getAllPots();

    @POST("create-pot")
    public Call<Pot> AddPot();
}
