package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.List;

public class Money { // class does not need to be static
    private static BigDecimal totalAmount = new BigDecimal(0.00);

    public static void addDollarsProvided() {
        BigDecimal cashGiven = new BigDecimal(UserInput.feedMoney());
        totalAmount = totalAmount.add(cashGiven);
        System.out.println(totalAmount);
    }

    public static BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public static BigDecimal subtractFromTotal(List<VendingItem> vendingItems, String location) {
        int i = 0;
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getQuantity() == 0) {
                System.out.println("This item is sold out. Please select another item.");
            }
            else if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                totalAmount = totalAmount.subtract(vendingItem.getPrice());
                System.out.println("Price: $" + vendingItem.getPrice() + " | Item purchased: "
                        + vendingItem.getName() + " | New balance: $" + totalAmount);
                vendingItem.setQuantity();
            }
            else {
                i++;
                if (i >= vendingItems.size()) {
                    System.out.println("This item does not exist. Please select another item.");
                }
            }

        }
        return totalAmount;
    }


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

        return null;
    }
}
