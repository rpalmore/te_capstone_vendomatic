package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;

import java.math.BigDecimal;
import java.util.List;

public class Money { // class does not need to be static
    private static BigDecimal quarter = new BigDecimal(0.25);
    private static BigDecimal dime = new BigDecimal(0.10);
    private static BigDecimal nickel = new BigDecimal(0.05);
    private static BigDecimal totalAmount = new BigDecimal(0.00);

    // create a new method to up dollars provided
    public static void addDollarsProvided() {
        BigDecimal cashGiven = new BigDecimal(UserInput.feedMoney());
        totalAmount = totalAmount.add(cashGiven);
        System.out.println(totalAmount);
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

        int remainingCents = totalAmount.multiply(new BigDecimal("100")).intValue();
        System.out.println(remainingCents);

        // figure out the quarters
        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;
        int quarterValue = 25;
        int dimeValue = 10;
        int nickelValue = 5;

        while (remainingCents >= 25){
            remainingCents -= quarterValue;
            numQuarters++;
            totalAmount = totalAmount.subtract(quarter);
        }while (remainingCents < 25 && remainingCents >= 10){
            remainingCents -= dimeValue;
            numDimes++;
            totalAmount = totalAmount.subtract(dime);  //something here doesn't work yet.
        }while ( remainingCents == 5){
            remainingCents -= nickelValue;
            numNickels++;
            totalAmount = totalAmount.subtract(nickel);
        }
        System.out.println("this is quarters: " + numQuarters + " This is dimes: " + numDimes
        + " This is the number of Nickels: " + numNickels);




//        //BigDecimal change = new BigDecimal(String.valueOf(totalAmount));
//        //BigDecimal changeInQuarters = new BigDecimal(String.valueOf(change.divide(quarter)));
//        BigDecimal changeInQuarters = totalAmount.divide(quarter);
//        BigDecimal remainingAfterQuarters = totalAmount.remainder(quarter);
//        BigDecimal remainingAfterDimes = remainingAfterQuarters.remainder(dime);
//        System.out.println("This is remainder after quarters: " + remainingAfterQuarters);
//        System.out.println("This is changeInQuarters: " + changeInQuarters);
//        System.out.println("This is remaining after dimes: " + remainingAfterDimes);
//        System.out.println("Returning " + changeInQuarters + " quarters.");
//
//
//
//
//        int quarterCounter = 0;
//        int dimeCounter = 0;
//        int nickelCounter = 0;
//        int resQuarter = totalAmount.compareTo(quarter);
//        int resAtLeastANickel = totalAmount.compareTo(nickel); // if we have money in the machine
//        BigDecimal moneyInMachine = new BigDecimal(totalAmount.compareTo(nickel));
//        int resDime = totalAmount.compareTo(dime);
//        int checkingMoneyValue = totalAmount.compareTo(BigDecimal.valueOf(0));
//        //int res4 = totalAmount.compareTo(BigDecimal.valueOf(0));
//        //if (res == 1) {// totalAmount > nickel
////        while(moneyInMachine.equals(totalAmount)){
////
////        }
//
//            while (checkingMoneyValue == 1) {
//
//                //if balanceInMachine is >= .25
//                //return at least 1 quarter
//                //if balanceInMachine is $ >= .05
//                //find the nickel and subtract .05 from balanceInMachine
//                //update balanceInMachine
//
//                if (resQuarter == 1) { // totalAmount >= quarter
//                    quarterCounter++;
//                    totalAmount = totalAmount.subtract(quarter);
//
//                    //System.out.println(quarterCounter);
//                    //res = totalAmount.compareTo(quarter);
//                    //resQuarter = totalAmount.compareTo(quarter);
//  //                  System.out.println("this is a quarter"+ quarterCounter);
//                }
//                if (resDime == 1) { // total is greater than a dime (and less than a quarter!)
//                    totalAmount = totalAmount.subtract(dime);
//                    dimeCounter++;
//                    //System.out.println(dimeCounter);
//                   // resAtLeastANickel = totalAmount.compareTo(dime);
//  //                  System.out.println("Do we make it here? " + dimeCounter);
//                }
//                else {  // if total is equal to nickel
//                    totalAmount = totalAmount.subtract(nickel);
//                    nickelCounter++;
//                   // resAtLeastANickel = totalAmount.compareTo(nickel);
//
//            }
//        }
 //       System.out.println("You get back: " +"quarters " + quarterCounter + " dimes: "+ dimeCounter + " Nickels: " + nickelCounter);


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