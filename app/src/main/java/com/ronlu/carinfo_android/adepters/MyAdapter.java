package com.ronlu.carinfo_android.adepters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ronlu.carinfo_android.R;
import com.ronlu.common.Car;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<Car> cars;

    public MyAdapter(Context context){
        this.context = context;
        cars =new ArrayList<>();
    }

    public void setCarList(List<Car> cars) {
        this.cars = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_cars, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .setDefaultRequestOptions(new RequestOptions().error(R.drawable.ic_launcher_background))
                .load(cars.get(position).getImagePath())
                .fitCenter()
                .into(holder.recyclerview_IMG_image);

        holder.recyclerview_LBL_licenseNumber.setText("License number: "+cars.get(position).getLicenseNumber());
        holder.recyclerview_LBL_manufacture.setText("Manufacture: "+cars.get(position).getManufacture());
        holder.recyclerview_LBL_manufactureYear.setText("Manufacture year: "+cars.get(position).getManufactureYear());
        holder.recyclerview_LBL_modelName.setText("Model name: "+cars.get(position).getModelName());
        holder.recyclerview_LBL_color.setText("Color: "+cars.get(position).getColor());
        holder.recyclerview_LBL_finishLevel.setText("Finish level: "+cars.get(position).getFinishLevel());
        holder.recyclerview_LBL_currentOwnership.setText("Current ownership: "+cars.get(position).getCurrentOwnership());


    }

    @Override
    public int getItemCount() {
        return cars != null ? cars.size() : 0;
    }
}
