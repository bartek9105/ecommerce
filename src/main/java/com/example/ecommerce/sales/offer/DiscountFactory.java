package com.example.ecommerce.sales.offer;

public class DiscountFactory {
    private static DiscountPolicy quantityDiscount() {
        return new QuantityDiscount(5, 0.20);
    }

    private static DiscountPolicy poppyAndJazzyDiscount() {
        return new QuantityDiscount(5, 0.20);
    }
}