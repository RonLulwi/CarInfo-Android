package com.ronlu.common.requests;

import com.ronlu.common.Car;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarRepository {

    private static CarRepository instance;
    private CarAPI service;
    private CallBack_cars callBack_cars;
    private CallBack_car callBack_car;

    public CarRepository() {
        this.service = RetrofitClient.getInstance();
    }

    public static CarRepository getInstance(){
        if(instance == null)
            instance = new CarRepository();
        return instance;
    }

    public void setCallBack_cars(CallBack_cars callBack_cars) {
        this.callBack_cars = callBack_cars;
    }

    public void setCallBack_car(CallBack_car callBack_car) {
        this.callBack_car = callBack_car;
    }

    public void getCar(String licenseNumber, CallBack_car callBack_car){
        setCallBack_car(callBack_car);
        service.getCar(licenseNumber).enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                if (response.isSuccessful() &&response.body() !=null){
                    callBack_car.OnReturnedCar(response.body());
                }
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {

            }
        });
    }

    public void getCars(CallBack_cars callBack_cars){
        setCallBack_cars(callBack_cars);
        service.getCars().enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callBack_cars.OnReturnedCars(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });
    }

    public void getCarsByColor(String color, CallBack_cars callBack_cars){
        this.callBack_cars = callBack_cars;
        service.getCarsByColor(color).enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callBack_cars.OnReturnedCars(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });
    }

    public void getCarsByManufacture(String manufacture, CallBack_cars callBack_cars){
        this.callBack_cars = callBack_cars;
        service.getCarsByManufacture(manufacture).enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(response.isSuccessful() && response.body() != null){
                    callBack_cars.OnReturnedCars(new ArrayList<>(response.body()));
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });
    }


    public interface CallBack_car{
        void OnReturnedCar(Car car);
    }

    public interface CallBack_cars{
        void OnReturnedCars(ArrayList<Car> cars);
    }




}
