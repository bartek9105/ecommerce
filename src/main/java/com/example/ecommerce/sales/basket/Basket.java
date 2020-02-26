package com.example.ecommerce.sales.basket;

import com.example.ecommerce.ProductCatalog.model.Book;
import com.example.ecommerce.sales.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Basket {
    public static Basket empty() {
        return new Basket();
    }

    private final HashMap<Book, Integer> productQuantities;

    public Basket() {
        this.productQuantities = new HashMap<>();
    }

    public void addProduct(Book product) {
        if (!isInBasket(product)) {
            putToBasket(product);
        } else {
            increaseQuantity(product);
        }
    }

    public List<BasketItem> getReservedProducts() {
        ArrayList<BasketItem> items = new ArrayList<>(productQuantities.size());

        productQuantities.forEach((product, quantity) -> items.add(new BasketItem(String.valueOf(product.getBookId()),
                quantity, product.getPrice())));

        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return productQuantities.isEmpty();
    }

    public int productsCount() {
        return productQuantities.size();
    }

    private void putToBasket(Book product) {
        productQuantities.put(product, 1);
    }

    private void increaseQuantity(Book product) {
        productQuantities.put(product, productQuantities.get(product) + 1);
    }

    private boolean isInBasket(Book product) {
        return productQuantities.containsKey(product);
    }

    public void clear() {
        this.productQuantities.clear();
    }
}
