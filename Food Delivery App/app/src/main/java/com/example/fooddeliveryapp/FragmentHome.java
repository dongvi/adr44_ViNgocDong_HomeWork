package com.example.fooddeliveryapp;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddeliveryapp.databinding.ActivityFragmentHomeBinding;
import com.example.fooddeliveryapp.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    ActivityFragmentHomeBinding binding;
    List<Food> foodsRcm;
    List<Food> foodsNew;
    List<Food> foodsOther;
    AdapterFood adapterFoodRcm;
    AdapterFood adapterFoodNew;
    AdapterFood adapterFoodOther;

    public static FragmentHome newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_fragment_home, container, false);

        foodsRcm = new ArrayList<>();
        foodsRcm.add(new Food("Ribeye steak", 12.5, 5, true, R.drawable.ribeye_steak));
        foodsRcm.add(new Food("Greek salad", 7, 4.5, false, R.drawable.greek_salad));
        foodsRcm.add(new Food("Mì tôm", 8, 4, false, R.drawable.mi_tom));
        foodsRcm.add(new Food("Cơm rang", 10.5, 3.5, true, R.drawable.com_rang));
        foodsRcm.add(new Food("Sườn chua ngọt", 20, 4.5, true, R.drawable.suon_chua_ngot));

        foodsNew = new ArrayList<>();
        foodsNew.add(new Food("Bún bò", 20.5, 4.5, false, R.drawable.ic_not_see));
        foodsNew.add(new Food("Cải chíp luộc", 15.5, 5, true, R.drawable.ic_not_see));
        foodsNew.add(new Food("Thịt heo xào nấm", 18, 5, true, R.drawable.ic_not_see));
        foodsNew.add(new Food("Gà xào xả ớt", 30.5, 4.5, false, R.drawable.ic_not_see));
        foodsNew.add(new Food("Gà kho cà ri", 35.5, 5, true, R.drawable.ic_not_see));

        foodsOther = new ArrayList<>();
        foodsOther.add(new Food("Cá chỉ nướng", 10.5, 4, true, R.drawable.ic_not_see));
        foodsOther.add(new Food("Mực khô nướng", 11.5, 4, true, R.drawable.ic_not_see));
        foodsOther.add(new Food("Bia 333", 9, 3, true, R.drawable.ic_not_see));
        foodsOther.add(new Food("Kẹo mút", 1, 3, false, R.drawable.ic_not_see));
        foodsOther.add(new Food("Cà phê chồn", 20, 4.5, true, R.drawable.ic_not_see));


        RecyclerView.LayoutManager layoutManagerRcm = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.rclRcm.setLayoutManager(layoutManagerRcm);
        adapterFoodRcm = new AdapterFood(foodsRcm);
        binding.rclRcm.setAdapter(adapterFoodRcm);

        RecyclerView.LayoutManager layoutManagerNew = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.rclNew.setLayoutManager(layoutManagerNew);
        adapterFoodNew = new AdapterFood(foodsNew);
        binding.rclNew.setAdapter(adapterFoodNew);

        RecyclerView.LayoutManager layoutManagerOther = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        binding.rclOther.setLayoutManager(layoutManagerOther);
        adapterFoodOther = new AdapterFood(foodsOther);
        binding.rclOther.setAdapter(adapterFoodOther);


        binding.btnSeeAllRcm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentDetail(FragmentNull.newInstance());
                FragmentSeeAll fragmentSeeAll = new FragmentSeeAll(foodsRcm);
                onFragment(fragmentSeeAll.newInstance());
            }
        });

        binding.btnSeeAllNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentDetail(FragmentNull.newInstance());
                FragmentSeeAll fragmentSeeAll = new FragmentSeeAll(foodsNew);
                onFragment(fragmentSeeAll.newInstance());
            }
        });

        binding.btnSeeAllOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFragmentDetail(FragmentNull.newInstance());
                FragmentSeeAll fragmentSeeAll = new FragmentSeeAll(foodsOther);
                onFragment(fragmentSeeAll.newInstance());
            }
        });

        adapterFoodRcm.setClick(new ClickOnFood() {
            @Override
            public void onFoodCardClick(Food food) {
                onFragment(FragmentNull.newInstance());
                FragmentDetailFood fragmentDetailFood = new FragmentDetailFood(food);
                onFragmentDetail(fragmentDetailFood.newInstance());
            }
        });

        adapterFoodNew.setClick(new ClickOnFood() {
            @Override
            public void onFoodCardClick(Food food) {
                onFragment(FragmentNull.newInstance());
                FragmentDetailFood fragmentDetailFood = new FragmentDetailFood(food);
                onFragmentDetail(fragmentDetailFood.newInstance());
            }
        });

        adapterFoodOther.setClick(new ClickOnFood() {
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