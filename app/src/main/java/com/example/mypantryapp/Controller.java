package com.example.mypantryapp;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.*;

public class Controller {

    public static ArrayList<Ingredient> pantry = new ArrayList<>();
    public ArrayList<Recipe> recipeBook = new ArrayList<>();

    public int index = 0;
    public boolean showButton = false;

    public Controller() {

    }


    public void addToPantry(double q, String u, String n){
        pantry.add(new Ingredient(q, u, n));
    }

    public void addRecipe(String n){
        recipeBook.add(new Recipe(n));
    }

    public void addRecipeNotes(String n){
        recipeBook.get(recipeBook.size()-1).setNote(n);
    }

    public void addToRecipeBook(double q, String u, String n){
        recipeBook.get(recipeBook.size()-1).addIngNeeded(new Ingredient(q, u, n));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<Recipe> getAvailable(){
        ArrayList<Recipe> available = new ArrayList<>();
        for (int i = 0; i < recipeBook.size(); i++){
            if(canMake(recipeBook.get(i), pantry)){
                available.add(recipeBook.get(i));
            }
        }
        return available;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean canMake(Recipe recipe, ArrayList<Ingredient> pantry){

        for (int i = 0; i < recipe.getIngNeeded().size(); i++){
            if (!containsName(pantry, recipe.getIngNeeded().get(i).getName()) ||
                    recipe.getIngNeeded().get(i).getMeasurement() > pantry.get(indexOfName(recipe.getIngNeeded().get(i).getName(), pantry)).getMeasurement()){

                return false;
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static boolean containsName(final ArrayList<Ingredient> list, final String name){
        return list.stream().anyMatch(o -> o.getName().equals(name));
    }

    public static void consumeRecipe(Recipe recipe){
        for (int i = 0; i < recipe.getIngNeeded().size(); i++){
            pantry.get(indexOfName(recipe.getIngNeeded().get(i).getName(), pantry)).changeMeasurement(-1 * recipe.getIngNeeded().get(i).getMeasurement());
        }
    }

    public static int indexOfName(String name, ArrayList<Ingredient> pantry){
        for (int i = 0; i < pantry.size(); i++){
            if (pantry.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void subtract(){

    }

}
