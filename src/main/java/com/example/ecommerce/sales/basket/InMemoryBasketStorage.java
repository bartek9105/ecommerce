package com.example.ecommerce.sales.basket;

import java.util.Optional;

public class InMemoryBasketStorage implements BasketStorage{
    @Override
    public Optional<Basket> loadForUser(String currentClientId){
        return Optional.of(null);
    }

    @Override
    public void save(Basket basket){

    }
}
