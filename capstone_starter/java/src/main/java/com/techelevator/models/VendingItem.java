package com.techelevator.models;

import java.math.BigDecimal;

public class VendingItem {
    private String location;
    private String name;
    private Double price;
    private String type;

    public VendingItem(String location, String name, Double price, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
    }
    //getters

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
