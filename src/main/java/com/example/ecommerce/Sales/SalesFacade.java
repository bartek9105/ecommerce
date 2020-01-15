package com.example.ecommerce.Sales;

public class SalesFacade {

    private SystemUserContext systemUserContext;

    public void addToBasket(long productId){
        String currentClientId = systemUserContext.getCurrentUserId();
    }
}
