package com.example.ecommerce.sales.snv;


import com.example.ecommerce.sales.basket.BasketStorage;
import com.example.ecommerce.sales.products.InMemoryProductCatalog;
import com.example.ecommerce.sales.products.ProductCatalog;
import com.example.ecommerce.system.SystemUserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalesConfiguration {
    @Bean
    SalesFacade createFacade(SystemUserContext systemUserContext, BasketStorage basketStorage, ProductCatalog productCatalog) {
        return new SalesFacade(systemUserContext, basketStorage, productCatalog);
    }
}
