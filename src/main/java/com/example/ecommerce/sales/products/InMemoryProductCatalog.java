package com.example.ecommerce.sales.products;

import com.example.ecommerce.ProductCatalog.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryProductCatalog implements ProductCatalog {

    private List<Book> availableProducts = new ArrayList<>();

    @Override
    public Optional<Book> load(String productId) {
        return availableProducts.stream()
                .filter(product -> product.getBookId().equals(productId))
                .findFirst();
    }

    public void setAvailableProducts(List<Book> asList) {
        this.availableProducts = asList;
    }
}
