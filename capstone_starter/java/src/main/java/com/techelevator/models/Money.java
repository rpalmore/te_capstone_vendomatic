package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.List;

public class Money { // class does not need to be static
    private static BigDecimal quarter = new BigDecimal(.25);
    private final BigDecimal DIME = new BigDecimal(.10);
    private final BigDecimal NICKEL = new BigDecimal(.05);
    private static BigDecimal totalAmount = new BigDecimal(0);

    // create a new method to up dollars provided
    public static void addDollarsProvided() {
        BigDecimal cashGiven = new BigDecimal(UserInput.feedMoney());
        totalAmount = totalAmount.add(cashGiven);
    }

    public static BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public static BigDecimal subtractFromTotal(List<VendingItem> vendingItems, String location) {

        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
//                cashTotal = (totalAmount.subtract(vendingItem.getPrice()));
                totalAmount = totalAmount.subtract(vendingItem.getPrice());
//                cashTotal = (totalAmount.subtract(vendingItem.getPrice()));
                System.out.println("Price: " + vendingItem.getPrice() + " Name: " + vendingItem.getName() + " Balance: "+ totalAmount);
            }
        }
        return totalAmount;
    }



    public static BigDecimal returnChange(){
        BigDecimal change = new BigDecimal(String.valueOf(totalAmount));
        System.out.println(change);
        change.divide(quarter);
        System.out.println("test" + change.divide(4));
        return null;
    }

//    public static void subtractFromTotal() {
//
//    }
}
    //  make searchfor public is used
//        vendingMachine.searchForItemInList(<VendingItem> ,UserInput.selectItem());