package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Money;
import com.techelevator.models.VendingItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "display";
            case "2":
                return "purchase";
            case "3":
                return "exit";
            default:
                return "";
        }

    }

    public static void pause() {
        System.out.print("Press enter to continue ");
        String enter = scanner.nextLine();
    }

    public static String purchase() {
        UserOutput.displayPurchaseChoices();
        System.out.println("1) Feed Money");
        System.out.println("2) Select product");
        System.out.println("3) Finish transaction");
        System.out.println();
        System.out.println("Current money provided: " + Money.getTotalAmount());// we will
        // concatenate using BigDecimal getBalance

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption2 = scanner.nextLine();
        String option2 = selectedOption2.trim().toLowerCase();

        switch (option2) {
            case "1":
                return "feeder";
            case "2":
                return "select product";
            case "3":
                return "finish transaction";
            default:
                return "";
        }
    }

    public static String feedMoney() {
        String dollarProvided = scanner.nextLine();
        return dollarProvided;
    }

    public static String selectItem(){
        System.out.println("Enter which product you would like? ");
        String itemUserSelected = scanner.nextLine();

       // this.location
        VendingMachine vendingMachine = new VendingMachine();
//                UserOutput userOutput = new UserOutput();
//                userOutput.getLocation;
//                vendingItemList.get

                // if this.location(i).equals(itemUserSelected){
        //              itemsUserSelected(i) == this.type
        //              itemsUserSelected(i) == this.price
            //          total = total- this.price

      //  for (VendingItem item : )
        return itemUserSelected;
    }
}

//    public static void listItems(List<VendingItem> vendingItemList){
//
//        for (VendingItem item : vendingItemList) {
//            System.out.println(item.getLocation() + " " + item.getName() + " " +
//                    item.getPrice() + " " + item.getType() + " " + item.getQuantity());
//        }