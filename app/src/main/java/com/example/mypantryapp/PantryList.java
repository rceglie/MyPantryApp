package com.example.mypantryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.FragmentPantryBinding;

public class PantryList extends Fragment {

    public Controller controller = MainActivity.controller;
    private FragmentPantryBinding binding;

    @Override
    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentPantryBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double q = Double.valueOf(((TextView)view.getRootView().findViewById(R.id.quantityBox)).getText().toString());
                String u = ((TextView)view.getRootView().findViewById(R.id.unitsBox)).getText().toString();
                String n = ((TextView)view.getRootView().findViewById(R.id.ingredientBox)).getText().toString();
                controller.addToPantry(q, u, n);

                NavHostFragment.findNavController(PantryList.this)
                        .navigate(R.id.action_BacktoPantry);
            }
        });


    }

        @Override
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }

    }