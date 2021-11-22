package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Money;
import com.techelevator.models.VendingItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    private static String dollarProvided;
    private static String itemUserSelected;
    //private String dollarProvided;

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
        System.out.print("Press enter to continue >> ");
        String enter = scanner.nextLine();
    }

    public static String purchase() {
        UserOutput.displayPurchaseChoices();
        System.out.println("1) Feed Money");
        System.out.println("2) Select product");
        System.out.println("3) Finish transaction");
        System.out.println();
        System.out.println("Current money provided: $" + Money.getTotalAmount());

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

    //private static String dollarProvided;

    public static String feedMoney() {
        boolean isValidString = false;
        while (!isValidString) {
            dollarProvided = scanner.nextLine();
            if ((dollarProvided.matches("[0-9]+"))){
                isValidString = true;
                return dollarProvided;
            }
            if (dollarProvided.equals(" ") || (dollarProvided.equals(""))
            || (dollarProvided.contains("[a-zA-Z]+") == false)) {
                System.out.println("Invalid value given, please enter a number.");
                isValidString = false;
           }
            //else {
//                isValidString = true;
//                return dollarProvided;
//            }
        }
        return dollarProvided;
    }

    //    double amountInDollars = 0;
//    String amountInString = input.nextLine();
//    boolean isValidNum = false;
//
//        if (amountInString.equals("") || amountInString.equals(" ")) { // Empty string check
//        System.out.println("Empty String");
//    } else if (amountInString.matches("-?\\d+(\\.\\d+)?")) { // valid double check
//        amountInDollars = Double.parseDouble(amountInString);
//        isValidNum = true;
//    } else {
//        System.out.println("Number Format error");
//    }

//    public static String feedMoney() {
//        if (dollarProvided.equals(" ")
//            || (dollarProvided.equals(""))) {
//            System.out.println("Please enter a number. ");
//        } else {
//                dollarProvided = scanner.nextLine();
//            }
//        return dollarProvided;
//    }




    // return amount user fed into machine, without calling feedMoney();
    public static BigDecimal moneyFed() {
        BigDecimal bigDecimal = new BigDecimal(dollarProvided);
        //return dollarProvided; still a string
        return bigDecimal;
    }


    public static String selectItem() {
        System.out.println("Enter the product number you would like: ");
        itemUserSelected = scanner.nextLine();
        return itemUserSelected;
    }

    public static String itemSelectedForLog() {
        return itemUserSelected;
    }


    }



//    public static void listItems(List<VendingItem> vendingItemList){
//
//        for (VendingItem item : vendingItemList) {
//            System.out.println(item.getLocation() + " " + item.getName() + " " +
//                    item.getPrice() + " " + item.getType() + " " + item.getQuantity());
//        }