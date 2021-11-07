package com.example.mypantryapp;

import android.text.Editable;

public class Ingredient{

    private String name;
    private double measurement;
    private String unit;


    public Ingredient(double i, String u, String n){
        name = n;
        unit = u;
        measurement = i;
    }


    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setMeasurement(double i){
        measurement = i;
    }

    public double getMeasurement(){
        return measurement;
    }

    public void changeMeasurement(double m){
        measurement = measurement + m;
    }

    public void setUnit(String u){
        unit = u;
    }

    public String getUnit(){
        return unit;
    }
}
