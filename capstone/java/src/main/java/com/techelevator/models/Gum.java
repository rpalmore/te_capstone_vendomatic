package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingItem{

    private String sound = "Chew Chew, Yum!";

    public Gum(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String getSound() {
        return sound;
    }
}
