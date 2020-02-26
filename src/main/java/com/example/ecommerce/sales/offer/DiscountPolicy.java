package com.example.ecommerce.sales.offer;

public interface DiscountPolicy {
    public Discount calculateDiscount(OfferItem item);
}
