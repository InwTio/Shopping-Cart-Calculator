package lib;

import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: คำนวณส่วนลด BOGO
        ArrayList<CartItem> bogoCart = new ArrayList<>();
        bogoCart.add(new CartItem("BOGO", "Banana", 25.0, 4)); // 50
        bogoCart.add(new CartItem("BOGO", "Apple", 15.0, 2)); // 15
        double total4 = ShoppingCartCalculator.calculateTotalPrice(bogoCart);
        if (total4 == 65.0) {
            System.out.println("PASSED: BOGO cart; buy four pay for two is correct (24.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BOGO cart; quantity expected 24.0 but got " + total4);
            failedCount++;
        }

        // Test 5: คำนวณส่วนลด BULK
        ArrayList<CartItem> bulkCart = new ArrayList<>();
        bulkCart.add(new CartItem("BULK", "Milk", 15.0, 6));      // 81
        double total5 = ShoppingCartCalculator.calculateTotalPrice(bulkCart);
        if (total5 == 81.0) {
            System.out.println("PASSED: BULK cart total is correct (81.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: BULK cart total expected 81.0 but got " + total5);
            failedCount++;
        }

         // Test 6: Quantity / Price ติดลบ
        ArrayList<CartItem> negativeCart = new ArrayList<>();
        negativeCart.add(new CartItem("BULK", "Milk", -12.0, 1));      // 81
        double total6 = ShoppingCartCalculator.calculateTotalPrice(negativeCart);
        if (total6 == 0.0) {
            System.out.println("PASSED: Negative cart total is correct (0.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Negative cart total expected 0.0 but got " + total6);
            failedCount++;
        }
        
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
        
    }
}
