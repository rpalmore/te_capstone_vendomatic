package com.techelevator.models;

import java.math.BigDecimal;

public interface Accountable {
    BigDecimal getBalance();
}

// we probably don't need this if we write
// methods in our money class.
