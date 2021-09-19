package com.example.order_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Shopping_Cart extends AppCompatActivity {

    View btnBack;
    TextView tvTTPay;
    ListView lvOrder;
    List<Food> foodsOrdered;
    List<String> list;
    AdapterFoodOrdered adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        btnBack = findViewById(R.id.btn_Back);
        tvTTPay = findViewById(R.id.tv_TTPay);
        lvOrder = findViewById(R.id.lv_order);
        foodsOrdered = new ArrayList<>();
        list = new ArrayList<>();

        Intent intent = getIntent();
        String tt = intent.getStringExtra("TT");
        tvTTPay.setText(tt + "$");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        list = (List<String>) (intent.getStringArrayListExtra("orders")).clone();

        for(String i : list){
            if(!exist(i))
                foodsOrdered.add(new Food(i, count(i)));
        }

        adapter = new AdapterFoodOrdered(foodsOrdered);
        lvOrder.setAdapter(adapter);
    }

    public boolean exist(String name){
        for(Food i : foodsOrdered)
            if(i.getName().compareToIgnoreCase(name) == 0)
                return true;
        return false;
    }

    public int count(String name){
        int amount = 0;
        for(String i : list)
            if(i.compareToIgnoreCase(name) == 0)
                amount++;
        return amount;
    }
}