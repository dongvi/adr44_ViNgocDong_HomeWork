package com.example.fooddeliveryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.databinding.ActivityFragmentSeeAllBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentSeeAll extends Fragment {

    ActivityFragmentSeeAllBinding binding;
    List<Food> foods;
    AdapterFood adapterFood;

    public FragmentSeeAll(List<Food> foods) {
        this.foods = foods;
    }

    public FragmentSeeAll() {
    }

    public FragmentSeeAll newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentSeeAll fragment = new FragmentSeeAll(foods);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_fragment_see_all, container, false);

        adapterFood = new AdapterFood(foods);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);

        binding.rclSeeAll.setLayoutManager(layoutManager);
        binding.rclSeeAll.setAdapter(adapterFood);

        adapterFood.setClick(new ClickOnFood() {
            @Override
            public void onFoodCardClick(Food food) {
                onFragment(FragmentNull.newInstance());
                FragmentDetailFood fragmentDetailFood = new FragmentDetailFood(food);
                onFragmentDetail(fragmentDetailFood.newInstance());
            }
        });

        return binding.getRoot();

    }

    public void onFragment(Fragment fragment){
        try {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onFragmentDetail(Fragment fragment){
        try {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container_detail, fragment).commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}