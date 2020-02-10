package com.example.ecommerce.sales.basket;

import com.example.ecommerce.sales.products.Product;

public class Basket {
    public static Basket empty(){
        return new Basket();
    }

    public int productsCount(){
        return 0;
    }

    public void addProduct(Product product){

    }
}
