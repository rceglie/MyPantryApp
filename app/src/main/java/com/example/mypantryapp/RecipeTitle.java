package com.example.mypantryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.FragmentRecipeBinding;

public class RecipeTitle extends Fragment {

    public Controller controller = MainActivity.controller;
    private FragmentRecipeBinding binding;

    @Override
    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentRecipeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                controller.addRecipe(((TextView)view.getRootView().findViewById(R.id.recipeTitle)).getText().toString());
                NavHostFragment.findNavController(RecipeTitle.this)
                        .navigate(R.id.action_toRecipeIngredients);
            }
    });

    }
    @Override
    public void onDestroyView () {
        super.onDestroyView();
        binding = null;
    }


}