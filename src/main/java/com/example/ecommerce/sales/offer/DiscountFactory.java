package com.example.ecommerce.sales.offer;

public class DiscountFactory {
    static DiscountPolicy quantityDiscount() {
        return new QuantityDiscount(2, 0.2);
    }
}