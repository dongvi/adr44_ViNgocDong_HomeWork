package com.example.fooddeliveryapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFoodType extends RecyclerView.Adapter<AdapterFoodType.ViewHolder> {

    List<FoodType> foodTypes;
    CLickOnFoodType click;

    public CLickOnFoodType getClick() {
        return click;
    }

    public void setClick(CLickOnFoodType click) {
        this.click = click;
    }

    public AdapterFoodType(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    @NonNull
    @Override
    public AdapterFoodType.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);

        AdapterFoodType.ViewHolder viewHolder = new AdapterFoodType.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterFoodType.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        FoodType foodType = foodTypes.get(position);

        holder.tvName.setText(foodType.getName());
        holder.img.setImageResource(foodType.getImg());

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onClickFoodTypeCard(position, foodType.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodTypes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView img;
        View card;
        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name_item);
            img = itemView.findViewById(R.id.img_item);
            card = itemView.findViewById(R.id.food_type_card);
        }
    }
}
