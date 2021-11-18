package com.techelevator.models;

import java.math.BigDecimal;

public abstract class VendingItem {
    private String location;
    private String name;
    private BigDecimal price;
    private String type;
    private String quantity = "5";

    public VendingItem(String location, String name, BigDecimal price, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;  // do we need this in our constructor?
    }

    //getters

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getQuantity() { return quantity;}
}
