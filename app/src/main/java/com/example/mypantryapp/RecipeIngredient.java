package com.example.mypantryapp;

import static android.view.View.TEXT_ALIGNMENT_GRAVITY;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.FragmentIngredientsBinding;

import java.util.ArrayList;

public class RecipeIngredient extends Fragment {

    public Controller controller = MainActivity.controller;
    private FragmentIngredientsBinding binding;

    @Override
    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentIngredientsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RecipeIngredient.this)
                        .navigate(R.id.action_AddtoRecipe);
            }
        });

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RecipeIngredient.this)
                        .navigate(R.id.action_toRecipeNotes);
            }
        });

        if (controller.recipeBook.size() > 0) {

            Recipe rec = controller.recipeBook.get(controller.recipeBook.size() - 1);
            if (rec.getIngNeeded().size() > 0) {

                for (int i = 0; i < rec.getIngNeeded().size(); i++) {

                    TextView txt2 = new TextView(getActivity());
                    Ingredient ing = rec.getIngNeeded().get(i);
                    String test = ing.getMeasurement() + " " + ing.getUnit() + " " + ing.getName();
                    txt2.setText(test);
                    txt2.setTextSize(18);
                    txt2.setHeight(105);
                    txt2.setTextAlignment(TEXT_ALIGNMENT_GRAVITY);
                    txt2.setTextColor(Color.BLACK);
                    LinearLayout lay2 = getActivity().findViewById(R.id.layoutIng);
                    lay2.addView(txt2);
                }
            }


        }


    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }

}
