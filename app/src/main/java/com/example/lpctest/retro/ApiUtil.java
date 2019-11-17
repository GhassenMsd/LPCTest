package com.example.lpctest.retro;

public class ApiUtil {

    private static final String BASE_URL = "http://recrutement.lepotcommuntest.fr/2019/recruiting/";

    public static RetrofitInterface getServiceClass(){
        return RetrofitAPI.getRetrofit(BASE_URL).create(RetrofitInterface.class);
    }
}