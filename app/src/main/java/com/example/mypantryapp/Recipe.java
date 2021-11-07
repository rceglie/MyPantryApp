package com.example.mypantryapp;

import java.util.*;

public class Recipe {

    private ArrayList<Ingredient> ingNeeded;
    //private ArrayList<Ingredient> ingOptional;
    private String name;
    private String note;


    public Recipe(String n) {
        ingNeeded = new ArrayList<Ingredient>();
        //ingOptional = new ArrayList<Ingredient>();
        name = n;
        note = "";
    }

    public void addIngNeeded(Ingredient ing) {
        ingNeeded.add(ing);
    }

    /*public void addIngOptional(Ingredient ing){
      ingOptional.add(ing);
    }*/

    public void setName(String n) {
        name = n;
    }

    public void setNote(String no) {
        note = no;
    }

    public ArrayList<Ingredient> getIngNeeded() {
        return ingNeeded;
    }

    /*public ArrayList<Ingredient> getIngOptional(){
        return ingOptional;
    }*/
    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }
}