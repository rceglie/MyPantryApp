package com.example.mypantryapp;

import static android.view.View.*;

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

import com.example.mypantryapp.databinding.FragmentSecondBinding;

public class MyPantry extends Fragment {

    public Controller controller = MainActivity.controller;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MyPantry.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MyPantry.this)
                        .navigate(R.id.action_SecondFragment_to_ThirdFragment);
                }

        });

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MyPantry.this)
                        .navigate(R.id.action_AddtoPantry);
            }
        });

        binding.updatePantry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < controller.pantry.size(); i++){
                    int ID = getResources().getIdentifier(i + "", "id", "mypantryapp");
                    controller.pantry.get(i).setMeasurement(Double.parseDouble(((TextView)v.getRootView().findViewById(ID)).getText().toString()));

                }
            }
        });



        for (int i = 0; i < controller.pantry.size(); i++){
            EditText txt1 = new EditText(getActivity());
            String test = String.valueOf(controller.pantry.get(i).getMeasurement());
            txt1.setText(test);
            txt1.setHeight(105);
            txt1.setTextSize(18);
            txt1.setId(i);
            txt1.setTextAlignment(TEXT_ALIGNMENT_TEXT_END);
            LinearLayout lay = getActivity().findViewById(R.id.pantryLayout);
            lay.addView(txt1);

            TextView txt2 = new TextView(getActivity());
            test = controller.pantry.get(i).getUnit() + " " + controller.pantry.get(i).getName();
            txt2.setText(test);
            txt2.setTextSize(18);
            txt2.setHeight(105);
            txt1.setTextAlignment(TEXT_ALIGNMENT_GRAVITY);
            txt2.setTextColor(Color.BLACK);
            LinearLayout lay2 = getActivity().findViewById(R.id.pantryLayout2);
            lay2.addView(txt2);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}