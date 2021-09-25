package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.fooddeliveryapp.databinding.ItemFoodBinding;

import java.text.DecimalFormat;
import java.util.List;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.ViewHolder> {

    List<Food> foods;
    DecimalFormat format = new DecimalFormat("0.###");
    ClickOnFood click;

    public ClickOnFood getClick() {
        return click;
    }

    public void setClick(ClickOnFood click) {
        this.click = click;
    }

    public AdapterFood(List<Food> foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public AdapterFood.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterFood.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Food food = foods.get(position);

        holder.tvName.setText(food.getName());
        holder.tvPrice.setText("$ " + String.format(format.format(food.getPrice())));
        holder.rtVoteStars.setRating(Float.parseFloat(String.valueOf(food.getVote())));
        holder.imgFood.setImageResource(food.getImg());

        if (food.isFavorite()){
            holder.btnHeartOff.setVisibility(View.GONE);
            holder.btnHeartOn.setVisibility(View.VISIBLE);
        }
        else{
            holder.btnHeartOn.setVisibility(View.GONE);
            holder.btnHeartOff.setVisibility(View.VISIBLE);
        }

        holder.btnHeartOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btnHeartOff.setVisibility(View.GONE);
                holder.btnHeartOn.setVisibility(View.VISIBLE);
            }
        });

        holder.btnHeartOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btnHeartOn.setVisibility(View.GONE);
                holder.btnHeartOff.setVisibility(View.VISIBLE);
            }
        });

        holder.foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onFoodCardClick(foods.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View btnHeartOn, btnHeartOff;
        TextView tvName, tvPrice;
        RatingBar rtVoteStars;
        ImageView imgFood;
        View foodCard;

        public ViewHolder(View itemView) {
            super(itemView);

            btnHeartOn = itemView.findViewById(R.id.btn_heart_on);
            btnHeartOff = itemView.findViewById(R.id.btn_heart_off);
            tvName = itemView.findViewById(R.id.tv_name_of_food);
            tvPrice = itemView.findViewById(R.id.tv_price_of_food);
            rtVoteStars = itemView.findViewById(R.id.rt_vote_stars);
            imgFood = itemView.findViewById(R.id.img_food);
            foodCard = itemView.findViewById(R.id.food_card);
        }
    }

}
