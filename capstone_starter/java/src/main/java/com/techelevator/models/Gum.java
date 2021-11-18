package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends VendingItem implements Soundable{

    // maybe this is where we add the quantity property?

    public Gum(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }


    @Override
    public String sound() {
        return "Chew Chew, Yum!";
    }
}
