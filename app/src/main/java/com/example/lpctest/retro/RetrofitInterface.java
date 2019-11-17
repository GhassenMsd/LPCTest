package com.example.lpctest.retro;


import com.example.lpctest.Entities.Pot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("get-pots")
    public Call<List<Pot>> getAllPots();

}
