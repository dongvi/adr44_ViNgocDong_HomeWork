package com.example.fooddeliveryapp;

import android.widget.ImageView;

public class Food {
    private String name;
    private boolean isFavorite;
    private double price, vote;
    private int img;

    public Food(String name, double price, double vote, boolean isFavorite, int img) {
        this.name = name;
        this.isFavorite = isFavorite;
        this.price = price;
        this.vote = vote;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
}
