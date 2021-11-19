package com.techelevator.models;

import java.math.BigDecimal;

public class Chips extends VendingItem{

    @Override
    public void setSound(String sound) {
        super.setSound(sound);
    }

    public Chips(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }


//    @Override
//    public String sound() {
//        return "Crunch Crunch, Yum!";
//    }
}
