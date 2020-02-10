package com.example.ecommerce.Sales;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> load(Long productId);
}
