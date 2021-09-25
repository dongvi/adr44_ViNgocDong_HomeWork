package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.databinding.ActivityFunctionBinding;

import java.util.List;

public class FunctionFavorites extends Fragment {

    ActivityFunctionBinding binding;
    List<Food> foods;
    AdapterFood adapterFood;
    Homepage homepage;

    public FunctionFavorites(List<Food> foods) {
        this.foods = foods;
    }
    public FunctionFavorites() {
    }


    public FunctionFavorites newInstance() {

        Bundle args = new Bundle();

        FunctionFavorites fragment = new FunctionFavorites(foods);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_function, container, false);
        homepage = (Homepage) getActivity();

        adapterFood = new AdapterFood(foods);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);

        binding.rclFavorites.setLayoutManager(layoutManager);
        binding.rclFavorites.setAdapter(adapterFood);

        adapterFood.setClick(new ClickOnFood() {
            @Override
            public void onFoodCardClick(Food food) {
                onFragment(FragmentNull.newInstance());
                FragmentDetailFood fragmentDetailFood = new FragmentDetailFood(food);
                onFragmentDetail(fragmentDetailFood.newInstance());
            }
        });

        binding.tvTitleFunction.setText(homepage.getTT());

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