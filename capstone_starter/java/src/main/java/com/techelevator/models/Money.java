package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.List;

public class Money { // class does not need to be static
    private static BigDecimal quarter = new BigDecimal(0.25);
    private static BigDecimal dime = new BigDecimal(0.10);
    private static BigDecimal nickel = new BigDecimal(0.05);
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
                System.out.println("Price: $" + vendingItem.getPrice() + " | Item purchased: " + vendingItem.getName() + " | New balance: $" + totalAmount);
            }
        }
        return totalAmount;
    }


    public static BigDecimal returnChange() {
        //BigDecimal change = new BigDecimal(String.valueOf(totalAmount));
        //BigDecimal changeInQuarters = new BigDecimal(String.valueOf(change.divide(quarter)));
        BigDecimal changeInQuarters = totalAmount.divide(quarter);
        BigDecimal remainingAfterQuarters = totalAmount.remainder(quarter);
        BigDecimal remainingAfterDimes = remainingAfterQuarters.remainder(dime);
//        System.out.println("This is remainder after quarters: " + remainingAfterQuarters);
//        System.out.println("This is changeInQuarters: " + changeInQuarters);
//        System.out.println("This is remaining after dimes: " + remainingAfterDimes);
//        System.out.println("Returning " + changeInQuarters + " quarters.");
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        int res3 = totalAmount.compareTo(quarter);
        int res = totalAmount.compareTo(nickel); // if we have money in the machine
        int res2 = totalAmount.compareTo(dime);
        //int res4 = totalAmount.compareTo(BigDecimal.valueOf(0));
        if (res == 1) {// totalAmount > nickel
            while (res == 1) {
                if (res == 1) { // totalAmount > nickel
                    totalAmount = totalAmount.subtract(quarter);
                    quarterCounter++;
                    //System.out.println(quarterCounter);
                    //res = totalAmount.compareTo(quarter);
                    res3 = totalAmount.compareTo(quarter);
                }
                if (res3 == 0) {// if total is equal to quarter
                    quarterCounter++;
                    totalAmount = totalAmount.subtract(quarter);
                    System.out.println("New balance: $" + totalAmount);
                } else if (res2 == 1) { // total is greater than a dime
                    totalAmount = totalAmount.subtract(dime);
                    dimeCounter++;
                    //System.out.println(dimeCounter);
                    res2 = totalAmount.compareTo(dime);
                    System.out.println("Do we make it here? " + dimeCounter);
                }
            }
        }
        System.out.println("You get back: " + quarterCounter);


        //System.out.println("TotalAmount is greater than .25");


//        } else if (res == -1) {
//            System.out.println("TotalAmount less than .25");
//        }
        // if totalAmount > quarter
        // then, subtract totalAmount - quarter
        // counter++
        // exit the loop, move to
        // if totalAmount > dime
        // then subtract totalAmount - dime
        // new counter++

        return null;
    }
}

//    public static void subtractFromTotal() {
//
//    }

    //  make searchfor public is used
//        vendingMachine.searchForItemInList(<VendingItem> ,UserInput.selectItem());