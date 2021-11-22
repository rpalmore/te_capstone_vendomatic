package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import logger.Logger;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Money { // class does not need to be static
    private static BigDecimal totalAmount = new BigDecimal(0.00);
    private static BigDecimal pricesAdded = new BigDecimal(0);
    private static int funds = 0;
    private static BigDecimal cashGiven = new BigDecimal(0);

    public static BigDecimal addDollarsProvided() {
       // if (UserInput.feedMoney() != null) {
            cashGiven = new BigDecimal(UserInput.feedMoney());
            totalAmount = totalAmount.add(cashGiven);
       // }
        return totalAmount;
    }

    public static BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public static BigDecimal subtractFromTotal(List<VendingItem> vendingItems, String location) {
        int i = 0;

            for (VendingItem vendingItem : vendingItems) {
                if (vendingItem.getLocation().equalsIgnoreCase(location)
                        && (totalAmount.compareTo(vendingItem.getPrice()) == 1
                        || totalAmount.equals(vendingItem.getPrice()))) {
                    if (vendingItem.getQuantity() <= 0) {
                        System.out.println("This item is sold out. Please select another item.");
                    } else if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                        totalAmount = totalAmount.subtract(vendingItem.getPrice());
                        System.out.println("Price: $" + vendingItem.getPrice() + " | Item purchased: "
                                + vendingItem.getName() + " | New balance: $" + totalAmount);
                        System.out.println(vendingItem.getSound());
                        vendingItem.setQuantity();
                        pricesAddedUp(vendingItems, location);
                    }
                }
                else if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                    if (totalAmount.compareTo(vendingItem.getPrice()) == -1) {
                        System.out.println("Insufficient funds. Please enter more money.");
                    }
                }
                else if (!vendingItem.getLocation().equalsIgnoreCase(location)){
                    i++;
                    if (i >= vendingItems.size()) {
                        System.out.println("This item does not exist. Please select another item.");
                   }
                }
            }
        return totalAmount;
    }

    private static String nameOfItem = "";
    public static String getVendingItemName(List<VendingItem> vendingItems, String location){
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                vendingItem.getName();
                String nameOfItem = vendingItem.getName();
            }
        }
        return nameOfItem;
    }

    public static String getLoggedName(){
        return nameOfItem;
    }

    public static BigDecimal loggingPricesAddedUp() {
        return UserInput.moneyFed().subtract(pricesAdded);
    }
    public static int logMoneyFed() {
        funds = UserInput.moneyFed().intValue();
        if (funds > 0) {
            return funds;
        }
        return 0;
    }
//    public static BigDecimal changeOwed(){
//        return totalAmount.subtract()
//    }


    public static BigDecimal returnChange() {

        int remainingCents = totalAmount.multiply(new BigDecimal("100")).intValue();

        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int quarterValue = 25;
        int dimeValue = 10;
        int nickelValue = 5;

        while (remainingCents >= quarterValue){
            remainingCents -= quarterValue;
            numQuarters++;
        } while (remainingCents < quarterValue && remainingCents >= dimeValue){
            remainingCents -= dimeValue;
            numDimes++;
        } while ( remainingCents == nickelValue){
            remainingCents -= nickelValue;
            numNickels++;
        }
        System.out.println("You get back: " + numQuarters + " quarters, " + numDimes
        + " dimes and " + numNickels + " nickels.");
        totalAmount = totalAmount.multiply(BigDecimal.valueOf(0));

        return totalAmount;
    }

    // returns total sales from vending machine in each session
    public static BigDecimal pricesAddedUp(List<VendingItem> vendingItems, String location) {
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                pricesAdded = pricesAdded.add(vendingItem.getPrice());
            }
        }
        return pricesAdded;
    }

}
