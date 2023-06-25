package com.ronlu.carinfo_android.requests;

import com.ronlu.carinfo_android.models.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CarAPI {

    @GET("get-car/{carLicenseNumber}")
    Call<Car> getCar(@Path(value = "carLicenseNumber", encoded = true) String carLicenseNumber);

    @GET("get-cars")
    Call<List<Car>> getCars();

    @GET("get-cars/color/{color}")
    Call<List<Car>> getCarsByColor(@Path(value = "color", encoded = true) String color);

    @GET("get-cars/manufacture/{manufacture}")
    Call<List<Car>> getCarsByManufacture(@Path(value = "manufacture", encoded = true) String manufacture);

}
