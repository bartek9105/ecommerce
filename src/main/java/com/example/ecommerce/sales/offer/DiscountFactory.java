package com.example.ecommerce.sales.offer;

public class DiscountFactory {
    static DiscountPolicy quantityDiscount() {
        return new QuantityDiscount(5, 0.20);
    }
}