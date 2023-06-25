package com.ronlu.carinfo_android.adepters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ronlu.carinfo_android.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    protected ImageView recyclerview_IMG_image;
    protected TextView recyclerview_LBL_licenseNumber;
    protected TextView recyclerview_LBL_manufacture;
    protected TextView recyclerview_LBL_manufactureYear;
    protected TextView recyclerview_LBL_modelName;
    protected TextView recyclerview_LBL_color;
    protected TextView recyclerview_LBL_finishLevel;
    protected TextView recyclerview_LBL_currentOwnership;


    public MyViewHolder(@NonNull View view) {
        super(view);
        recyclerview_IMG_image = view.findViewById(R.id.recyclerview_IMG_image);
        recyclerview_LBL_licenseNumber = view.findViewById(R.id.recyclerview_LBL_licenseNumber);
        recyclerview_LBL_manufacture = view.findViewById(R.id.recyclerview_LBL_manufacture);
        recyclerview_LBL_manufactureYear = view.findViewById(R.id.recyclerview_LBL_manufactureYear);
        recyclerview_LBL_modelName = view.findViewById(R.id.recyclerview_LBL_modelName);
        recyclerview_LBL_color = view.findViewById(R.id.recyclerview_LBL_color);
        recyclerview_LBL_finishLevel = view.findViewById(R.id.recyclerview_LBL_finishLevel);
        recyclerview_LBL_currentOwnership = view.findViewById(R.id.recyclerview_LBL_currentOwnership);


    }
}
