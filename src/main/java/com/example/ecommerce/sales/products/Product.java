package com.example.ecommerce.sales.products;

import java.math.BigDecimal;

public class Product {
    private String productId;
    private BigDecimal price;
    private Integer quantity;
    private String title;
    private String author;

    public Product(String productId, BigDecimal price, String title, String author) {
        this.productId = productId;
        this.price = price;
        this.quantity = 1;
        this.title = title;
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
