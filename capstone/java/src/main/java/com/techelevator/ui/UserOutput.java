package com.techelevator.ui;

import com.techelevator.models.VendingItem;

import java.util.List;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }
    public static void displayVendingStockItems()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Items");
        System.out.println("***************************************************");
        System.out.println();
    }
    //for user choice 1
    public static void listItems(List<VendingItem> vendingItemList){
        displayVendingStockItems();
        for (VendingItem item : vendingItemList) {
            System.out.println(item.getLocation() + ": " + item.getName() + " ($" +
                    item.getPrice() + ") Type: " + item.getType() + ". Available: " + item.getQuantity());
        }

    }
    //for user choice 2
    public static void displayPurchaseChoices()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Purchase");
        System.out.println("***************************************************");
        System.out.println();
    }

}
