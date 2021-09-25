package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.fooddeliveryapp.databinding.ActivityFragmentDetailFoodBinding;
import com.example.fooddeliveryapp.databinding.ActivityHomePageBinding;

import java.text.DecimalFormat;


public class FragmentDetailFood extends Fragment {

    ActivityFragmentDetailFoodBinding binding;
    Food food;
    DecimalFormat format = new DecimalFormat("0.###");
    Homepage homepage;

    public FragmentDetailFood(Food food) {
        this.food = food;
    }

    public FragmentDetailFood newInstance() {

        Bundle args = new Bundle();

        FragmentDetailFood fragment = new FragmentDetailFood(food);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_fragment_detail_food, container, false);

        homepage = (Homepage) getActivity();

        binding.tvNameOfFoodDetail.setText(food.getName());
        binding.tvPriceOfFoodDetail.setText("$ " + String.format(format.format(food.getPrice())));
        binding.rtVoteStarsDetail.setRating(Float.parseFloat(String.valueOf(food.getVote())));
        binding.imgFoodDetail.setImageResource(food.getImg());

        homepage.getView().setVisibility(View.GONE);


        if (food.isFavorite()){
            binding.btnHeartOff.setVisibility(View.GONE);
            binding.btnHeartOn.setVisibility(View.VISIBLE);
        }
        else{
            binding.btnHeartOn.setVisibility(View.GONE);
            binding.btnHeartOff.setVisibility(View.VISIBLE);
        }

        binding.btnHeartOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnHeartOff.setVisibility(View.GONE);
                binding.btnHeartOn.setVisibility(View.VISIBLE);
            }
        });

        binding.btnHeartOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnHeartOn.setVisibility(View.GONE);
                binding.btnHeartOff.setVisibility(View.VISIBLE);
            }
        });


        return binding.getRoot();
    }
}