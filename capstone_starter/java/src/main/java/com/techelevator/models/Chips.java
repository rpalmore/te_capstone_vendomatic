package com.techelevator.models;

import java.math.BigDecimal;

public class Chips extends VendingItem{


   // private String sound = "Crunch Crunch, Yum!";

//    @Override
//    public void setSound(String sound) {
//        this.sound = sound;
//    }

    public Chips(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

}
