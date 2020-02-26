package com.example.ecommerce.sales.products;

import com.example.ecommerce.ProductCatalog.model.Book;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Book> load(String productId);
}
