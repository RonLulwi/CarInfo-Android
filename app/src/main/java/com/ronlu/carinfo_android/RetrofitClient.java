package com.ronlu.carinfo_android;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static CarAPI instance;
    private static final String BASE_URL = "http://10.100.102.17:8081/cars/v1/";

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
