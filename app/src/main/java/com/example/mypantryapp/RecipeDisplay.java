package com.example.mypantryapp;

import static android.view.View.TEXT_ALIGNMENT_GRAVITY;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;
import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.RecipeDisplayBinding;

public class RecipeDisplay extends Fragment {

    private RecipeDisplayBinding binding;
    public Controller controller = MainActivity.controller;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = RecipeDisplayBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RecipeDisplay.this)
                        .navigate(R.id.action_closeDisplayRecipe);
            }
        });

        binding.doneButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.consumeRecipe(controller.recipeBook.get(controller.index));
                NavHostFragment.findNavController(RecipeDisplay.this)
                        .navigate(R.id.action_closeDisplayRecipe);
            }
        });

        Recipe recipe = controller.recipeBook.get(controller.index);

        ((TextView)getActivity().findViewById(R.id.display1Name)).setText(recipe.getName());
        String print = "";
        for (int i = 0; i < recipe.getIngNeeded().size(); i++){
            print = print + "-- " + recipe.getIngNeeded().get(i).getMeasurement() + " "+ recipe.getIngNeeded().get(i).getUnit() + " "+ recipe.getIngNeeded().get(i).getName() + "\n";
        }
        ((TextView)getActivity().findViewById(R.id.display1Ingredients)).setText(print);
        ((TextView)getActivity().findViewById(R.id.display1Notes)).setText(recipe.getNote());

        if (controller.showButton){
            (getActivity().findViewById(R.id.doneButton3)).setVisibility(View.VISIBLE);
        } else{
            (getActivity().findViewById(R.id.doneButton3)).setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}