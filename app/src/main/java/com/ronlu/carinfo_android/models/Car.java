package com.ronlu.carinfo_android.models;

public class Car {

    private String licenseNumber;
    private String manufacture;
    private String manufactureYear;
    private String modelName;
    private String color;
    private String finishLevel;
    private String currentOwnership;
    private String imagePath;


    public Car() {
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFinishLevel() {
        return finishLevel;
    }

    public void setFinishLevel(String finishLevel) {
        this.finishLevel = finishLevel;
    }

    public String getCurrentOwnership() {
        return currentOwnership;
    }

    public void setCurrentOwnership(String currentOwnership) {
        this.currentOwnership = currentOwnership;
    }

    @Override
    public String toString() {
        return "Car{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                ", finishLevel='" + finishLevel + '\'' +
                ", currentOwnership='" + currentOwnership + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
