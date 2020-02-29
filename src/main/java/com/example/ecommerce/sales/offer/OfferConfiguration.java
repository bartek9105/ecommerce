package com.example.ecommerce.sales.offer;

import com.example.ecommerce.sales.basket.BasketStorage;
import com.example.ecommerce.system.SystemUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OfferConfiguration {
    @Autowired
    BasketStorage basketStorage;

    @Autowired
    OfferMaker offerMaker;

    @Autowired
    SystemUserContext systemUserContext;
    @Bean
    OfferMaker getOfferMaker() {
        return new OfferMaker();
    }

    @Bean
    OfferFinder offerFinder() {
        return new OfferFinder(
                basketStorage,
                offerMaker,
                systemUserContext
        );
    }
}
