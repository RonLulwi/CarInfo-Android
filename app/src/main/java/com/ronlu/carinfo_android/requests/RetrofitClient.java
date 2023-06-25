package com.ronlu.carinfo_android.requests;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static CarAPI instance;
    private static final String BASE_URL = "Your HTTP Base URL";

    public static CarAPI getInstance(){
        if(instance == null)
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(CarAPI.class);
        return instance;

    }
}
