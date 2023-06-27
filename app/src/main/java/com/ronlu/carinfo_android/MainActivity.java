package com.ronlu.carinfo_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ronlu.carinfo_android.adepters.MyAdapter;
import com.ronlu.common.Car;
import com.ronlu.common.requests.CarRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CarRepository.CallBack_car, CarRepository.CallBack_cars {
    private SearchView main_SV_searchView;
    private AppCompatButton main_BTN_search;
    private RadioGroup main_RGP_radioGroup;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private CarRepository mRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initViews();


    }

    private void findViews() {
        main_SV_searchView = findViewById(R.id.main_SV_searchView);
        main_BTN_search = findViewById(R.id.main_BTN_search);
        mRecyclerView =findViewById(R.id.mRecyclerview);
        main_RGP_radioGroup =findViewById(R.id.main_RGP_radioGroup);

    }

    private void initViews() {
        mRepo = CarRepository.getInstance();
        initRecyclerViewAdapter();
        main_BTN_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = String.valueOf(main_SV_searchView.getQuery());
                int TargetId = main_RGP_radioGroup.getCheckedRadioButtonId();

                if(TargetId == R.id.ALL){
                    mRepo.getCars(MainActivity.this);
                }else if(value.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter value to the search bar!", Toast.LENGTH_SHORT).show();
                }else{
                    if (TargetId == R.id.MANU)
                        mRepo.getCarsByManufacture(value, MainActivity.this);
                    else if (TargetId == R.id.COLOR)
                        mRepo.getCarsByColor(value, MainActivity.this);
                    else if (TargetId == R.id.LP)
                        mRepo.getCar(value, MainActivity.this);
                }
            }
        });

    }
    private void initRecyclerViewAdapter() {
        mAdapter = new MyAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void OnReturnedCar(Car car) {
        ArrayList<Car> data = new ArrayList<>();
        data.add(car);
        mAdapter.setCarList(data);
    }

    @Override
    public void OnReturnedCars(ArrayList<Car> cars) {
        mAdapter.setCarList(cars);
    }
}