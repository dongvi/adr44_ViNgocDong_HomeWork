package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.fooddeliveryapp.databinding.ActivityHomePageBinding;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    ActivityHomePageBinding binding;
    List<Food> foodsRcm;
    List<Food> foodsNew;
    List<Food> foodsOther;
    List<Food> foodsF;
    String title = "";
    View user;
    List<FoodType> foodTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);

        binding.btnHomeOff.setVisibility(View.GONE);
        binding.btnMenuOn.setVisibility(View.GONE);
        binding.btnFavoritesOn.setVisibility(View.GONE);

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

        foodsF = new ArrayList<>();

        Homepage.this.clone(foodsRcm, foodsF);
        Homepage.this.clone(foodsNew, foodsF);
        Homepage.this.clone(foodsOther, foodsF);

        foodTypes = new ArrayList<>();
        foodTypes.add(new FoodType("Salads", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Main dishes", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Soups", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Paste", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Pizza", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Desserts", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Hot drinks", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Cold drinks", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("Alcohol", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("x", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("y", R.drawable.ic_not_see));
        foodTypes.add(new FoodType("z", R.drawable.ic_not_see));

        binding.btnMenuOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnHomeOn.setVisibility(View.GONE);
                binding.btnHomeOff.setVisibility(View.VISIBLE);
                binding.btnFavoritesOn.setVisibility(View.GONE);
                binding.btnFavoritesOff.setVisibility(View.VISIBLE);
                binding.btnMenuOn.setVisibility(View.VISIBLE);
                binding.btnMenuOff.setVisibility(View.GONE);

                binding.btnUserProfile.setVisibility(View.VISIBLE);

                title = getString(R.string.btn_menu);

                onFragmentDetail(FragmentNull.newInstance());
                FunctionMenu functionMenu = new FunctionMenu(foodTypes);
                onFragment(functionMenu.newInstance());
            }
        });

        binding.btnMenuOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnUserProfile.setVisibility(View.VISIBLE);

                title = getString(R.string.btn_menu);

                onFragmentDetail(FragmentNull.newInstance());
                FunctionMenu functionMenu = new FunctionMenu(foodTypes);
                onFragment(functionMenu.newInstance());
            }
        });

        binding.btnHomeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnHomeOn.setVisibility(View.VISIBLE);
                binding.btnHomeOff.setVisibility(View.GONE);
                binding.btnFavoritesOn.setVisibility(View.GONE);
                binding.btnFavoritesOff.setVisibility(View.VISIBLE);
                binding.btnMenuOn.setVisibility(View.GONE);
                binding.btnMenuOff.setVisibility(View.VISIBLE);

                binding.btnUserProfile.setVisibility(View.VISIBLE);
                onFragmentDetail(FragmentNull.newInstance());
                onFragment(FragmentHome.newInstance());
            }
        });

        binding.btnHomeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnUserProfile.setVisibility(View.VISIBLE);
                onFragmentDetail(FragmentNull.newInstance());
                onFragment(FragmentHome.newInstance());
            }
        });

        binding.btnFavoritesOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnHomeOn.setVisibility(View.GONE);
                binding.btnHomeOff.setVisibility(View.VISIBLE);
                binding.btnFavoritesOn.setVisibility(View.VISIBLE);
                binding.btnFavoritesOff.setVisibility(View.GONE);
                binding.btnMenuOn.setVisibility(View.GONE);
                binding.btnMenuOff.setVisibility(View.VISIBLE);
                binding.btnUserProfile.setVisibility(View.VISIBLE);

                title = getString(R.string.btn_favorites);

                onFragmentDetail(FragmentNull.newInstance());
                FunctionFavorites functionFavorites = new FunctionFavorites(foodsF);
                onFragment(functionFavorites.newInstance());
            }
        });

        binding.btnFavoritesOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnUserProfile.setVisibility(View.VISIBLE);

                title = getString(R.string.btn_favorites);

                onFragmentDetail(FragmentNull.newInstance());
                FunctionFavorites functionFavorites = new FunctionFavorites(foodsF);
                onFragment(functionFavorites.newInstance());
            }
        });

        binding.btnUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnUserProfile.setVisibility(View.GONE);
                onFragment(FragmentNull.newInstance());
                onFragmentDetail(UserProfile.newInstance());
            }
        });

        binding.btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Cart.class);

                startActivity(intent);
            }
        });


        onFragment(FragmentHome.newInstance());

    }


    public void onFragment(Fragment fragment){
        try{
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void onFragmentDetail(Fragment fragment){
        try{
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_detail, fragment).commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clone(List<Food> a, List<Food> b){
        for(Food i : a)
            if(i.isFavorite()){
                b.add(i);
            }
    }

    public String getTT(){
        return title;
    }

    public View getView(){
        return binding.btnUserProfile;
    }
}