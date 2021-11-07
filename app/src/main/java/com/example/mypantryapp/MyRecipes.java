package com.example.mypantryapp;

import static android.view.View.TEXT_ALIGNMENT_GRAVITY;
import static android.view.View.TEXT_ALIGNMENT_TEXT_END;
import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.*;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.mypantryapp.databinding.*;

public class MyRecipes extends Fragment {

    private FragmentThirdBinding binding;
    public Controller controller = MainActivity.controller;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MyRecipes.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        binding.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MyRecipes.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment);

            }
        });

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MyRecipes.this)
                        .navigate(R.id.action_AddtoRecipes);
            }
        });

        for (int i = 0; i < controller.recipeBook.size(); i++){
            Button btn1 = new Button(getActivity());
            String test = String.valueOf(controller.recipeBook.get(i).getName());
            btn1.setText(test);
            btn1.setHeight(105);
            btn1.setTextSize(18);
            btn1.setId(i);
            btn1.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
            LinearLayout lay = getActivity().findViewById(R.id.recipeLayout);

            int finalI = i;
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    controller.index = finalI;
                    controller.showButton = false;
                    NavHostFragment.findNavController(MyRecipes.this)
                            .navigate(R.id.action_displayRecipe);

                }
            });

            lay.addView(btn1);

            if(controller.recipeBook.size() == 0){
                (getActivity().findViewById(R.id.prompt1)).setEnabled(true);
                ((TextView)getActivity().findViewById(R.id.prompt1)).setTextSize(25);
                ((TextView)getActivity().findViewById(R.id.prompt1)).setTextColor(Color.BLACK);
                ((TextView)getActivity().findViewById(R.id.prompt1)).setVisibility(View.VISIBLE);

            } else {
                (getActivity().findViewById(R.id.prompt1)).setVisibility(View.INVISIBLE);
                (getActivity().findViewById(R.id.prompt1)).setEnabled(false);
            }

        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}

