package com.example.order_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class AdapterFood extends BaseAdapter {
    List<Food> foods;

    public AdapterFood(List<Food> foods) {
        this.foods = foods;
    }


    @Override
    public int getCount() {
        return foods.size();
    }

    @Override
    public Object getItem(int pst) {
        return foods.get(pst);
    }

    @Override
    public long getItemId(int pst) {
        return pst;
    }

    @Override
    public View getView(int pst, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.food_item, parent, false);

        TextView tvName = view.findViewById(R.id.tvFoodName);

        Food food = foods.get(pst);

        tvName.setText(food.getName());

        return view;
    }
}
