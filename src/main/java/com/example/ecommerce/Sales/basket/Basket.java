package com.example.ecommerce.Sales.basket;

import com.example.ecommerce.Sales.products.Product;

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
