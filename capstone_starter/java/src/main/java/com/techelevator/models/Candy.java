package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends VendingItem implements Soundable{

    public Candy(String location, String name, BigDecimal price, String type) {
        super(location, name, price, type);
    }

    @Override
    public String sound() {
        return "Munch Munch, Yum!";
    }
}
