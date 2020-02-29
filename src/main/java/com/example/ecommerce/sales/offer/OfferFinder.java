package com.example.ecommerce.sales.offer;

import com.example.ecommerce.sales.basket.Basket;
import com.example.ecommerce.sales.basket.BasketStorage;
import com.example.ecommerce.system.SystemUserContext;

public class OfferFinder {
    private BasketStorage basketStorage;
    private OfferMaker offerMaker;
    private SystemUserContext userContext;

    public OfferFinder(BasketStorage basketStorage, OfferMaker offerMaker, SystemUserContext userContext) {
        this.basketStorage = basketStorage;
        this.offerMaker = offerMaker;
        this.userContext = userContext;
    }

    public OfferData currentOffer(){
        Offer offer = offerMaker.calculateOffer(
                basketStorage.loadForUser(userContext.getCurrentUserId())
                        .orElse(Basket.empty())
                        .getReservedProducts(),
                DiscountFactory.quantityDiscount()
        );

        return new OfferData(offer.getTotal(), offer.getItems().size());
    }
}
