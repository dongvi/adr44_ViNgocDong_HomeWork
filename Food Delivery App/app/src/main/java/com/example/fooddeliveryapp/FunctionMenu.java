package com.example.fooddeliveryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.databinding.ActivityFunctionBinding;
import com.example.fooddeliveryapp.databinding.ActivityFunctionMenuBinding;

import java.util.ArrayList;
import java.util.List;

public class FunctionMenu extends Fragment {

    ActivityFunctionMenuBinding binding;
    List<FoodType> foodTypes;
    AdapterFoodType adapterFoodType;
    Homepage homepage;
    List<Food> salads;
    List<Food> mainDishes;
    List<Food> Soups;
    List<Food> paste;
    List<Food> Pizza;
    List<Food> desserts;
    List<Food> hotDrinks;
    List<Food> coldDrinks;
    List<Food> alcohol;

    public FunctionMenu(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public FunctionMenu() {
    }

    public FunctionMenu newInstance() {

        Bundle args = new Bundle();

        FunctionMenu fragment = new FunctionMenu(foodTypes);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_function_menu, container, false);
        homepage = (Homepage) getActivity();

        adapterFoodType = new AdapterFoodType(foodTypes);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3, RecyclerView.VERTICAL, false);

        binding.rclMenu.setLayoutManager(layoutManager);
        binding.rclMenu.setAdapter(adapterFoodType);
        binding.tvTitleFunction.setText(homepage.getTT());

        salads = new ArrayList<>();
        mainDishes = new ArrayList<>();
        Soups = new ArrayList<>();
        paste = new ArrayList<>();
        Pizza = new ArrayList<>();
        desserts = new ArrayList<>();
        hotDrinks = new ArrayList<>();
        coldDrinks = new ArrayList<>();
        alcohol = new ArrayList<>();

        salads.add(new Food("salad 1", 0, 3, false, R.drawable.ic_not_see));
        salads.add(new Food("salad 2", 0, 2, false, R.drawable.ic_not_see));
        salads.add(new Food("salad 3", 0, 3, false, R.drawable.ic_not_see));
        salads.add(new Food("salad 4", 0, 4, false, R.drawable.ic_not_see));
        salads.add(new Food("salad 5", 0, 3, false, R.drawable.ic_not_see));
        mainDishes.add(new Food("mainDishes 1", 0, 3, false, R.drawable.ic_not_see));
        mainDishes.add(new Food("mainDishes 2", 0, 2, false, R.drawable.ic_not_see));
        mainDishes.add(new Food("mainDishes 3", 0, 3, false, R.drawable.ic_not_see));
        mainDishes.add(new Food("mainDishes 4", 0, 4, false, R.drawable.ic_not_see));
        mainDishes.add(new Food("mainDishes 5", 0, 3, false, R.drawable.ic_not_see));
        Soups.add(new Food("Soup 1", 0, 3, false, R.drawable.ic_not_see));
        Soups.add(new Food("Soup 2", 0, 2, false, R.drawable.ic_not_see));
        Soups.add(new Food("Soup 3", 0, 3, false, R.drawable.ic_not_see));
        Soups.add(new Food("Soup 4", 0, 4, false, R.drawable.ic_not_see));
        Soups.add(new Food("Soup 5", 0, 3, false, R.drawable.ic_not_see));
        paste.add(new Food("paste 1", 0, 3, false, R.drawable.ic_not_see));
        paste.add(new Food("paste 2", 0, 2, false, R.drawable.ic_not_see));
        paste.add(new Food("paste 3", 0, 3, false, R.drawable.ic_not_see));
        paste.add(new Food("paste 4", 0, 4, false, R.drawable.ic_not_see));
        paste.add(new Food("paste 5", 0, 3, false, R.drawable.ic_not_see));
        Pizza.add(new Food("Pizza 1", 0, 3, false, R.drawable.ic_not_see));
        Pizza.add(new Food("Pizza 2", 0, 2, false, R.drawable.ic_not_see));
        Pizza.add(new Food("Pizza 3", 0, 3, false, R.drawable.ic_not_see));
        Pizza.add(new Food("Pizza 4", 0, 4, false, R.drawable.ic_not_see));
        Pizza.add(new Food("Pizza 5", 0, 3, false, R.drawable.ic_not_see));
        desserts.add(new Food("dessert 1", 0, 3, false, R.drawable.ic_not_see));
        desserts.add(new Food("dessert 2", 0, 2, false, R.drawable.ic_not_see));
        desserts.add(new Food("dessert 3", 0, 3, false, R.drawable.ic_not_see));
        desserts.add(new Food("dessert 4", 0, 4, false, R.drawable.ic_not_see));
        desserts.add(new Food("dessert 5", 0, 3, false, R.drawable.ic_not_see));
        hotDrinks.add(new Food("hotDrink 1", 0, 3, false, R.drawable.ic_not_see));
        hotDrinks.add(new Food("hotDrink 2", 0, 2, false, R.drawable.ic_not_see));
        hotDrinks.add(new Food("hotDrink 3", 0, 3, false, R.drawable.ic_not_see));
        hotDrinks.add(new Food("hotDrink 4", 0, 4, false, R.drawable.ic_not_see));
        hotDrinks.add(new Food("hotDrink 5", 0, 3, false, R.drawable.ic_not_see));
        coldDrinks.add(new Food("coldDrink 1", 0, 3, false, R.drawable.ic_not_see));
        coldDrinks.add(new Food("coldDrink 2", 0, 2, false, R.drawable.ic_not_see));
        coldDrinks.add(new Food("coldDrink 3", 0, 3, false, R.drawable.ic_not_see));
        coldDrinks.add(new Food("coldDrink 4", 0, 4, false, R.drawable.ic_not_see));
        coldDrinks.add(new Food("coldDrink 5", 0, 3, false, R.drawable.ic_not_see));
        alcohol.add(new Food("alcohol 1", 0, 3, false, R.drawable.ic_not_see));
        alcohol.add(new Food("alcohol 2", 0, 2, false, R.drawable.ic_not_see));
        alcohol.add(new Food("alcohol 3", 0, 3, false, R.drawable.ic_not_see));
        alcohol.add(new Food("alcohol 4", 0, 4, false, R.drawable.ic_not_see));
        alcohol.add(new Food("alcohol 5", 0, 3, false, R.drawable.ic_not_see));


        adapterFoodType.setClick(new CLickOnFoodType() {
            @Override
            public void onClickFoodTypeCard(int pst, String name) {
                onFragmentDetail(FragmentNull.newInstance());
                FragmentSeeAll fragmentSeeAll;
                switch (pst){
                    case 0:
                        fragmentSeeAll = new FragmentSeeAll(salads);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 1:
                        fragmentSeeAll = new FragmentSeeAll(mainDishes);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 2:
                        fragmentSeeAll = new FragmentSeeAll(Soups);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 3:
                        fragmentSeeAll = new FragmentSeeAll(paste);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 4:
                        fragmentSeeAll = new FragmentSeeAll(Pizza);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 5:
                        fragmentSeeAll = new FragmentSeeAll(desserts);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 6:
                        fragmentSeeAll = new FragmentSeeAll(hotDrinks);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 7:
                        fragmentSeeAll = new FragmentSeeAll(coldDrinks);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    case 8:
                        fragmentSeeAll = new FragmentSeeAll(alcohol);
                        onFragment(fragmentSeeAll.newInstance());
                        break;
                    default:
                        Toast.makeText(getContext(), name + " is not updated!", Toast.LENGTH_LONG).show();
                        break;
                }
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