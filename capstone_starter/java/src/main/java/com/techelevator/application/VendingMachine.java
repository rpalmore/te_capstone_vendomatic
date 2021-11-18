package com.techelevator.application;

import com.techelevator.models.VendingItem;
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

            if (choice.equals("display")) {
                // display the vending machine slots
                listAllItems(vendingItemList);
            } else if (choice.equals("purchase")) {
                System.out.println("purchase");
            } else if (choice.equals("exit")) {
                System.out.println("Good Bye!");
                break;
            }
        }

    }

    private List<VendingItem> readFromFile(){
        File filePath = new File("vendingmachine.csv");
        List<VendingItem> vendingItemsList = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(filePath);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // check |
                String[] lineArray = line.split("\\|");
                String location = lineArray[0];
                String name = lineArray[1];


                //Check this if money is not working properly!
                Double price = Double.parseDouble(lineArray[2]);
                String type = lineArray[3];

                VendingItem items = new VendingItem(location, name, price, type);
                vendingItemsList.add(items);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        }
        return vendingItemsList;
    }

    private void listAllItems(List<VendingItem> vendingItemList) {
   //     System.out.println(listAllItems);
        UserOutput.listItems(vendingItemList);
    }
}
