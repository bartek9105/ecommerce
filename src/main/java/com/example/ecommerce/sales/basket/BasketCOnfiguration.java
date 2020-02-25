package com.example.ecommerce.sales.basket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketCOnfiguration {
    @Bean
    BasketStorage basketStorage() {
        return new InMemoryBasketStorage();
    }
}
