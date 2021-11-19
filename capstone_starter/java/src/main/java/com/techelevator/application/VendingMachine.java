package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    public void run() {
        List<VendingItem> vendingItemList = readFromFile();
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            //Display switch
            // display the vending machine slots
            if (choice.equals("display")) {
                listAllItems(vendingItemList);
                System.out.println();
                UserInput.pause();

                // Purchase if else switch statements
            } else if (choice.equals("purchase")) {
                boolean buying = true;
                while (buying) {
                    String choice2 = UserInput.purchase();
                    if (choice2.equals("feeder")) {
                        System.out.println("Please insert money.");
                        Money.addDollarsProvided();
                    } else if (choice2.equals("select product")) {
                        //displaying items
                        listAllItems(vendingItemList);
                        // start your check
                        // 1. if item exists
                        // 2. if item is not sold out

                        searchForItemInList(vendingItemList, UserInput.selectItem());
                        // if ( item does not exist) {
                        // sout: item does not exist ...
                        // bounce user back to purchase
                        // if item exists, subtract, dispense...


                        // adding the product from the list
                        // subtracting the money
                        // subtract 1 from the product list
                        // check the total if it is enough
                        // in stock?
                        // dispense item with sound
                        // display new balance

                    } else if (choice2.equals("finish transaction")) {
                        buying = false;
                        // print receipt
                        // give out change
                    }
                }
                //exits
            } else if (choice.equals("exit")) {

                System.out.println("Goodbye!");
                System.exit(0);
                break;
            }
        }

    }

    private List<VendingItem> readFromFile() {
        File filePath = new File("vendingmachine.csv");
        List<VendingItem> vendingItemsList = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(filePath);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");
                String location = lineArray[0];
                String name = lineArray[1];
                BigDecimal price = new BigDecimal(lineArray[2]);
                String type = lineArray[3];
                // We think we don't need to tease out by type, but we're leaving this for now.
                // If we remove, we still have to add to our Vending Items List.
                if (type.equalsIgnoreCase("gum")) {
                    Gum gum = new Gum(location, name, price, type);
                    vendingItemsList.add(gum);
                } else if (type.equalsIgnoreCase("candy")) {
                    Candy candy = new Candy(location, name, price, type);
                    vendingItemsList.add(candy);
                } else if (type.equalsIgnoreCase("drink")) {
                    Drinks drink = new Drinks(location, name, price, type);
                    vendingItemsList.add(drink);
                } else if (type.equalsIgnoreCase("chip")) {
                    Chips chips = new Chips(location, name, price, type);
                    vendingItemsList.add(chips);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        }
        return vendingItemsList;
    }

    private void listAllItems(List<VendingItem> vendingItemList) {
        UserOutput.listItems(vendingItemList);
    }

    //defensive programming -- we have to handle null at some point.
    private VendingItem searchForItemInList(List<VendingItem> vendingItems, String location) {
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {
                    //System.out.println(vendingItem.getType());
                    if (vendingItem.getType().equalsIgnoreCase("chip")) {
                        System.out.println("Crunch Crunch, Yum!");
                    }
                    return vendingItem;
                }
            }
            System.out.println("Item does not exist! Please enter an item in the list.");
//            UserInput.purchase();
//            UserInput.feedMoney();
            return null;
        }
    }


