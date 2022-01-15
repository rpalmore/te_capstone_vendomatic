package com.techelevator.models;

import java.math.BigDecimal;

public class Chip extends VendingItem{

   private String sound = "Crunch Crunch, Yum!";


    public Chip(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }


    @Override
    public String getSound() {
        return sound;
    }
}
