package com.techelevator.models;
import com.techelevator.ui.UserInput;
import java.math.BigDecimal;
import java.util.List;

public class Money {
    private static BigDecimal totalAmount = new BigDecimal(0.00);
    private static BigDecimal pricesAdded = new BigDecimal(0);
    private static BigDecimal funds = new BigDecimal(0);
    private static BigDecimal cashGiven = new BigDecimal(0);
    private static String nameOfItem;


    public static BigDecimal addDollarsProvided() {
            cashGiven = new BigDecimal(UserInput.feedMoney());
            totalAmount = totalAmount.add(cashGiven);
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
                        getVendingItemName(vendingItems, location);
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

    public static String getVendingItemName(List<VendingItem> vendingItems, String location){
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                nameOfItem = vendingItem.getName();
            }

        }
        return nameOfItem;
    }

    public static String getLoggedName(){
        return nameOfItem;
    }
//        private static BigDecimal logThisPlease = new BigDecimal(0);

    public static BigDecimal loggingPricesAddedUp() { // method is forcing exit when included in logger
       // logThisPlease = UserInput.moneyFed().subtract(pricesAdded);
       // return totalAmount.subtract(pricesAdded);
        return UserInput.moneyFed().subtract(pricesAdded);
    }
    public static BigDecimal logMoney() { // method is forcing exit when included in logger
        // logThisPlease = UserInput.moneyFed().subtract(pricesAdded);
        // return totalAmount.subtract(pricesAdded);
        return UserInput.moneyFed().subtract(pricesAdded);
    }
    public static BigDecimal logMoneyFed() { // method is forcing exit when included in logger
        funds = totalAmount.subtract(UserInput.moneyFed());
        return funds;
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

        return totalAmount;
    }

    // this is for optional sales receipt that totals up all sales
    public static BigDecimal pricesAddedUp(List<VendingItem> vendingItems, String location) {
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                pricesAdded = pricesAdded.add(vendingItem.getPrice());
            }
        }
        return pricesAdded;
    }

}
