package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends VendingItem{

    private String sound = "Glug Glug, Yum!";


    public Drink(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String getSound() {
        return sound;
    }
}
