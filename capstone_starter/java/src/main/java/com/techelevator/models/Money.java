package com.techelevator.models;

import com.techelevator.ui.UserInput;

import java.math.BigDecimal;

public class Money { // class does not need to be static
    private static BigDecimal totalAmount = new BigDecimal(0);


    // create a new method to up dollars provided
    public static void addDollarsProvided(){
        BigDecimal dollarProvided = new BigDecimal(UserInput.feedMoney());

        totalAmount = totalAmount.add(dollarProvided);
    }

    public static BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
