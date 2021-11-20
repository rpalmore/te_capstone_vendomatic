package com.techelevator.models;

import java.math.BigDecimal;

public abstract class VendingItem {
    private String location;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity = 5;
    private String sound;

    public VendingItem(String location, String name, BigDecimal price, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
        //this.sound = sound;
        this.quantity = quantity;  // do we need this in our constructor?
    }

   // We could also add the quantity in the constructor, with the value of 5.
    // we could add a subtractOne method in here to subtract from the starting quantity.

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

    public int getQuantity() { return quantity;}

    public String getSound() {return sound;}

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int setQuantity() {
        return this.quantity = quantity - 1;
    }

}
