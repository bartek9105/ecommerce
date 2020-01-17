package com.example.ecommerce.dto;

import java.math.BigDecimal;

public class BookData {
    private Long bookId;
    private String title;
    private String author;
    private BigDecimal price;

    public BookData(Long bookId, String title, String author, BigDecimal price){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
