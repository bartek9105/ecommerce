package com.example.ecommerce.Sales.products;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> load(Long productId);
}
