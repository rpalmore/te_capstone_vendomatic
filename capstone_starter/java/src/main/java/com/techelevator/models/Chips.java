package com.techelevator.models;

import java.math.BigDecimal;

public class Chips extends VendingItem implements Soundable{

    public Chips(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String sound() {
        return "Crunch Crunch, Yum!";
    }
}
