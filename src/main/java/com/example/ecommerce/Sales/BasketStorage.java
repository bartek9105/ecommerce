package com.example.ecommerce.Sales;

import java.util.Optional;

public interface BasketStorage {
    Optional<Basket> loadForUser(String currentClientId);

    void save(Basket basket);
}