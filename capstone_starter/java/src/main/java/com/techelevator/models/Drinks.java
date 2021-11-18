package com.techelevator.models;

import java.math.BigDecimal;

public class Drinks extends VendingItem implements Soundable{


    public Drinks(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String sound() {
        return "Glug Glug, Yum!";
    }

}
