package com.example.order_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.order_app.databinding.ActivityOrderMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order_Main extends AppCompatActivity {

    View btnSC;
    Button btnOrder;
    TextView tvResult;
    List<Food> foods;
    List<String> orders;
    ListView lvFood;
    TextView tvNumberOfFood, tvTTPrice;
    AdapterFood adapterFood;
    int autoNumber = 0;
    double tt = 0;

    ActivityOrderMainBinding binding;

    DecimalFormat format = new DecimalFormat("0.###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_main);
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_main);


        btnSC = findViewById(R.id.btn_Cart);
        btnOrder = findViewById(R.id.btn_Order);
        tvResult = findViewById(R.id.tv_Result);
        lvFood = findViewById(R.id.lv_food);
        tvNumberOfFood = findViewById(R.id.tv_numberOfFood);
        tvTTPrice = findViewById(R.id.tv_TTPrice);

        foods = new ArrayList<>();
        orders = new ArrayList<>();

        Food f1 = new Food("Pizza Panda", 10f);
        Food f2 = new Food("KFC Super", 10f);
        Food f3 = new Food("Bread Eggs", 10f);
        Food f4 = new Food("Coca Cola", 10f);
        Food f5 = new Food("Chicken Super", 10f);
        Food f6 = new Food("Cup Cake", 10f);

        foods.add(f1);
        foods.add(f2);
        foods.add(f3);
        foods.add(f4);
        foods.add(f5);
        foods.add(f6);

        adapterFood = new AdapterFood(foods);
        lvFood.setAdapter(adapterFood);

        tvNumberOfFood.setText("0");
        tvTTPrice.setText("0$");

        btnSC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Shopping_Cart.class);
                intent.putExtra("TT", String.format(format.format(tt)));
                intent.putStringArrayListExtra("orders", (ArrayList<String>) orders);
                startActivity(intent);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText(getResources().getText(R.string.tv_thank));
                tvNumberOfFood.setText("0");
                tvTTPrice.setText("0$");
                autoNumber = 0;
                tt = 0;
                orders.clear();
            }
        });

        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pst, long l) {
                tvResult.setText("");
                Food food = foods.get(pst);
                autoNumber++;
                tt += food.getPrice();

                orders.add(food.getName());

                tvNumberOfFood.setText(String.format("%d", autoNumber));
                tvTTPrice.setText(String.format(format.format(tt)) + "$");
            }
        });
    }
}