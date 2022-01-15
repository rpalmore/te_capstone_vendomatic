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

    public void run() throws IOException {
        List<VendingItem> vendingItemList = readFromFile();

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

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

                        Logger logger = new Logger("log.txt");
                        logger.write(LocalDateTime.now().toString() + " FEED MONEY: $" + UserInput.moneyFed() +
                                " $" + Money.getTotalAmount());
                        try {
                            logger.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else if (choice2.equals("select product")) {
                        //displaying items
                        listAllItems(vendingItemList);

                            Money.subtractFromTotal(vendingItemList, UserInput.selectItem());
                            Logger logger = new Logger("log.txt");
                            logger.write(LocalDateTime.now().toString() + " " +
                                    Money.getLoggedName() + " " +
                                    UserInput.itemSelectedForLog() + " $" +
                                    //Money.loggingPricesAddedUp()  + // this breaks our program
                                    //Money.logMoneyFed() + " $" + // this breaks our program
                                    Money.getTotalAmount());
                            try {
                                logger.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                    } else if (choice2.equals("finish transaction")) {
                        buying = false;
                        Money.returnChange();
                        Logger logger = new Logger("log.txt");
                        logger.write(LocalDateTime.now().toString() +
                                " Give Change: $" + " " +
                                //Money.loggingPricesAddedUp() + " " + // this is breaking purchase/finish process.
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
                //break;
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

    }


