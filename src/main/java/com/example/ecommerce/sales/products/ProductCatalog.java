package com.example.ecommerce.sales.products;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> load(Long productId);
}
