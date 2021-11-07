package com.example.mypantryapp;

import static android.view.View.TEXT_ALIGNMENT_TEXT_START;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mypantryapp.databinding.FragmentFirstBinding;

import java.util.ArrayList;


public class GetCookin extends Fragment {
    private FragmentFirstBinding binding;
    Controller controller = MainActivity.controller;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(GetCookin.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(GetCookin.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });

        ArrayList<Recipe> available = controller.getAvailable();
        if(available.size() > 0){
            for (int i = 0; i < available.size(); i++){
                Button btn3 = new Button(getActivity());
                String test = String.valueOf(available.get(i).getName());
                btn3.setText(test);
                btn3.setHeight(105);
                btn3.setTextSize(18);
                btn3.setId(i + 100);
                btn3.setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
                LinearLayout lay = getActivity().findViewById(R.id.availableL);

                int finalI = i;
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        controller.index = finalI;
                        controller.showButton = true;
                        NavHostFragment.findNavController(GetCookin.this)
                                .navigate(R.id.action_displayRecipe);
                    }
                });

                lay.addView(btn3);
            }
        }




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}