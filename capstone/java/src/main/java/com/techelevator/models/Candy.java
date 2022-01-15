package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem{

    private String sound = "Munch Munch, Yum!";


    public Candy(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String getSound() {
        return sound;
    }
}
