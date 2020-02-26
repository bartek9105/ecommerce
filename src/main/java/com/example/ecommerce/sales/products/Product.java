package com.example.ecommerce.sales.products;

import java.math.BigDecimal;

public class Product {
    private String productId;
    private BigDecimal price;
    private Integer quantity;

    public Product(String productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
        this.quantity = 1;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
