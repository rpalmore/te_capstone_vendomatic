//package com.techelevator.models;
//
//import com.techelevator.ui.UserInput;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//import static org.junit.Assert.*;
//
//public class MoneyTest {
//
//    @Test
//    public void addDollarsProvided() {
//
//        Money money = new Money();
//        //Scanner scanner = new Scanner(System.in);
//
//        //String userInput = scanner.nextLine();
//
//        BigDecimal actual = new BigDecimal(4);
//
//        BigDecimal total = new BigDecimal(0);
//
//        Assert.assertEquals(actual, total);
//
//            //Arrange
////            StringExercises stringExercises = new StringExercises();
////            //Act
////            String actual = stringExercises.firstTwo("Hello");
////            String expected = "He";
////
////            //Assert
////            Assert.assertEquals(expected, actual);
//        }
//
//    @Test
//    public void getVendingItemName() {
//
//        Money money = new Money();
//
//        List<VendingItem> vendingItems = new ArrayList<>();
//
//           //vendingItems.add(0, "Crunchy");
//           vendingItems.add(1, "Moonpie");
//           vendingItems.add("a1", "Crunchy", 1.50, "Chips");
//
//
//         //String actual = money.get(0);
//        //Map<String, Integer> actual = wordCount.getCount(words);
//        List<String> actual = Money.getVendingItemName(vendingItems, location);
//        String actual = Money.getVendingItemName(List<VendingItem>, String location);
//
//         //Money actual = Money.vendingItems.get(0);
//         String expected = "Crunchy";
//
//        Assert.assertEquals(actual, expected);
//    }
//}
//
// // EXAMPLE FOR INSPIRATION:
//
////    public void getCount_pass_a_b_c_d_returns_map_a_1_b_1_c_1_d_1() {
////
////        WordCount wordCount = new WordCount();
////
////        String[] words = {"a", "b", "c", "d"};
////
////        Map<String, Integer> expected = new HashMap<>();
////        expected.put("a", 1);
////        expected.put("b", 1);
////        expected.put("c", 1);
////        expected.put("d", 1);
////
////        Map<String, Integer> actual = wordCount.getCount(words);
////
////        Assert.assertEquals(expected, actual);
////    }
