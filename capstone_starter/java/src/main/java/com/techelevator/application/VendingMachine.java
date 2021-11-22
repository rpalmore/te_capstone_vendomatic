package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import logger.Logger;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    BigDecimal itemPrice;
    public void run() throws IOException {
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
                        // hit enter and break program
                        Money.addDollarsProvided();
                        // logger
                        Logger logger = new Logger("log.txt");
                        logger.write(LocalDateTime.now().toString() + " " + UserInput.moneyFed() +
                                " runningTotal" + Money.getTotalAmount());
                        try {
                            logger.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    } else if (choice2.equals("select product")) {
                        //displaying items
                        listAllItems(vendingItemList);

                            // 01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
                            Money.subtractFromTotal(vendingItemList, UserInput.selectItem());
                            Logger logger = new Logger("log.txt");
                            logger.write(LocalDateTime.now().toString() + " " +
                                  //searchForItemInList(vendingItemList, UserInput.itemSelectedForLog()).getName() + " " +
                                    Money.getLoggedName() + " " +
                                    UserInput.itemSelectedForLog() + " " +
                               //     Money.logMoneyFed() + " " +

//                                    Money.addDollarsProvided() + " " + // this is breaking flow
                                    Money.getTotalAmount() + " ");
                            try {
                                logger.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                    } else if (choice2.equals("finish transaction")) {
                        buying = false;
                        Money.returnChange();
                        //System.out.println(Money.pricesAddedUp());
                        Logger logger = new Logger("log.txt");
                        logger.write(LocalDateTime.now().toString() + " new " +
                                Money.loggingPricesAddedUp() + " message finishing and cashing out. New balance: $ " +
                                Money.getTotalAmount());
                        try {
                            logger.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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

                if (type.equalsIgnoreCase("gum")) {
                    Gum gum = new Gum(location, name, price, type);
                    vendingItemsList.add(gum);
                } else if (type.equalsIgnoreCase("candy")) {
                    Candy candy = new Candy(location, name, price, type);
                    vendingItemsList.add(candy);
                } else if (type.equalsIgnoreCase("drink")) {
                    Drink drink = new Drink(location, name, price, type);
                    vendingItemsList.add(drink);
                } else if (type.equalsIgnoreCase("chip")) {
                    Chip chips = new Chip(location, name, price, type);
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
    public VendingItem searchForItemInList(List<VendingItem> vendingItems, String location) {
        for (VendingItem vendingItem : vendingItems) {
            if (vendingItem.getLocation().equalsIgnoreCase(location)) {

                    return vendingItem;
                }
            }
            System.out.println("Item does not exist! Please enter an item in the list.");

            return null;
        }
    }


