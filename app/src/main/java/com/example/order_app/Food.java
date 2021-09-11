package com.example.order_app;

public class Food {
    private String name;
    private int amount;
    private double price;

    public Food(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Food(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
