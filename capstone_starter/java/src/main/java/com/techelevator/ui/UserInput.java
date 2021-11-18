package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
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

        public static void pause(){
        System.out.print("Press enter to continue ");
        String enter = scanner.nextLine();
    }
    public static String purchase(){
        UserOutput.displayPurchaseChoices();
        System.out.println("1) Feed Money");
        System.out.println("2) Select product");
        System.out.println("3) Finish transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption2 = scanner.nextLine();
        String option2 = selectedOption2.trim().toLowerCase();

        switch (option2) {
            case "1":
                return "money";
            case "2":
                return "Select product";
            case "3":
                return "Finish transaction";
            default:
                return "";
        }
    }

}
