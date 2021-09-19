package com.example.order_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterFoodOrdered extends BaseAdapter {
    List<Food> foodsOrdered;

    public AdapterFoodOrdered(List<Food> foodsOrdered) {
        this.foodsOrdered = foodsOrdered;
    }

    @Override
    public int getCount() {
        return foodsOrdered.size();
    }

    @Override
    public Object getItem(int pst) {
        return foodsOrdered.get(pst);
    }

    @Override
    public long getItemId(int pst) {
        return pst;
    }

    @Override
    public View getView(int pst, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.food_item, parent, false);

        TextView tvOrdered = view.findViewById(R.id.tvFoodName);

        Food food = foodsOrdered.get(pst);

        tvOrdered.setText(food.getName() + "(" + food.getAmount() + ")");

        return view;
    }
}
