package com.example.mypantryapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.FragmentItemBinding;

public class RecipeAddIngredient extends Fragment {

    public Controller controller = MainActivity.controller;
    private FragmentItemBinding binding;

    @Override
    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentItemBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double q = Double.valueOf(((EditText)view.getRootView().findViewById(R.id.quantityBox2)).getText().toString());
                String u = ((EditText)view.getRootView().findViewById(R.id.unitsBox2)).getText().toString();
                String n = ((EditText)view.getRootView().findViewById(R.id.ingredientBox2)).getText().toString();
                controller.addToRecipeBook(q, u, n);

                NavHostFragment.findNavController(RecipeAddIngredient.this)
                        .navigate(R.id.action_BacktoConfirmItem);

            }
        });



    }

    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }

}